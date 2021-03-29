package com.customer.invite.service;

import com.customer.invite.AppConstants;
import com.customer.invite.model.Customer;
import com.customer.invite.model.GeoLocation;
import com.customer.invite.util.FileReader;
import com.customer.invite.util.GeoLocationHelper;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class CustomerService {

    private static final Logger LOGGER = Logger.getLogger(CustomerService.class.getName());

    private CustomerService() {
    }

    public static List<Customer> getCustomersWithinDistance(List<Customer> customersToFilter, GeoLocation filterLocation, Double kilometerRange) {
        List<Customer> customersInRange = new ArrayList<>();
        DecimalFormat decimalFormat=new DecimalFormat("#.##");

        for (Customer customer : customersToFilter) {
            double distanceCalc= GeoLocationHelper.getDistanceInKm(customer.getGeoLocation(),filterLocation);
            if (kilometerRange.compareTo(distanceCalc) > 0) {
                customer.setDistance(decimalFormat.format(distanceCalc)+AppConstants.KM_STRING);
                customersInRange.add(customer);
            }
        }

        return customersInRange;
    }

    public static List<Customer> processCustomerData(String fileUrl, double validRange) {
        LOGGER.log(Level.INFO, () -> "Getting List of customers within " +
                validRange + "km Range of (" + AppConstants.DUBLIN_OFFICE_GPS_COORDINATE+ ")");
        try {

            LOGGER.log(Level.INFO, () -> "Reading Customer data from " + fileUrl);
            InputStream inputStream = new URL(fileUrl).openStream();
            List<Customer> customers = FileReader.getCustomers(inputStream);

            List<Customer> customersInRange = getCustomersWithinDistance(customers, AppConstants.DUBLIN_OFFICE_GPS_COORDINATE, validRange);

            LOGGER.log(Level.INFO, () -> "Total customers " + customers.size() + ", of which " + customersInRange.size() + " are within a " + validRange + "km Range.");

            customersInRange.sort(Comparator.comparingInt(Customer::getUserId));
            StringBuilder sb = new StringBuilder();
            for (Customer customer : customersInRange) {
                sb.append(customer).append(System.lineSeparator());
            }

            LOGGER.log(Level.INFO, () -> "List of customers in range: " + System.lineSeparator() + sb);
            return customersInRange;

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "An Error has occurred, Exiting Application: " + e.toString());
            return new ArrayList<>();
        }

    }
}
