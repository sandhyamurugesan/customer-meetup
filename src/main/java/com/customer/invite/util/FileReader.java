package com.customer.invite.util;

import com.customer.invite.AppConstants;
import com.customer.invite.model.Customer;
import com.customer.invite.model.GeoLocation;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class FileReader {

    private static final Logger LOGGER = Logger.getLogger(FileReader.class.getName());

    private FileReader() {
    }

    public static List<Customer> getCustomers(InputStream inputStream) throws IOException {
        List<JSONObject> customers = new ArrayList<>();

        try (BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream, AppConstants.JSON_TXT_FILE_ENCODING))) {
            String line;
            while ((line = rd.readLine()) != null) {
                customers.add(new JSONObject(line));
            }
        }
        return getCustomersListFromJsonList(customers);
    }
    public static List<Customer> getCustomersListFromJsonList(List<JSONObject> customerJsonObjects){
        List<Customer> customers = new ArrayList<>();
        for(JSONObject jsonObject: customerJsonObjects){
            GeoLocation location = new GeoLocation(
                    Double.parseDouble(jsonObject.get(AppConstants.JSON_ATTR_LATITUDE).toString()),
                    Double.parseDouble(jsonObject.get(AppConstants.JSON_ATTR_LONGITUDE).toString()));
            Customer customer = new Customer(
                    Integer.parseInt( jsonObject.get(AppConstants.JSON_ATTR_USER_ID).toString()),
                    jsonObject.get(AppConstants.JSON_ATTR_USER_NAME).toString(),
                    location
            );
            customers.add(customer);
        }

        return customers;
    }

}
