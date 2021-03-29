package com.customer.invite.service;

import com.customer.invite.AppConstants;
import com.customer.invite.model.Customer;
import com.customer.invite.model.GeoLocation;
import com.customer.invite.service.CustomerService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomerServiceTest {

    @Test
    public void getCustomersWithinDistance() {

        List<Customer> customersToFilter = new ArrayList<>();
        customersToFilter.add(new Customer(2, "Dolan", new GeoLocation(53.2451022d,-6.238335d)));
        customersToFilter.add(new Customer(8, "Dave", new GeoLocation(55.033d,-8.112d)));
        customersToFilter.add(new Customer(4, "Harry", new GeoLocation(53d,-7d)));
        customersToFilter.add(new Customer(6, "Colum", new GeoLocation(51.92893d,-10.27699d)));

        GeoLocation filterLocation = new GeoLocation(53.339428,-6.257664);

        Double kilometerRange = 100d;

        List<Customer> customersInRange = CustomerService.getCustomersWithinDistance(customersToFilter, filterLocation, kilometerRange);

        assertEquals(2, customersInRange.size());
        assertEquals(2, customersInRange.get(0).getUserId());
        assertEquals(4, customersInRange.get(1).getUserId());

    }

    @Test
    public void processCustomerData() {

        List<Customer> customers = CustomerService.processCustomerData(AppConstants.JSON_FILE_INPUT_URL,
                100d);

        assertEquals("Ian Kehoe", customers.get(0).getUserName());
        assertEquals(11, customers.get(4).getUserId());

    }

    @Test
    public void processCustomerDataError(){

        List<Customer> customers = CustomerService.processCustomerData("No URL",
                100d);

        assertTrue(customers.isEmpty());

    }
}