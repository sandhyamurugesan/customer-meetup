package com.customer.invite.controller;

import com.customer.invite.AppConstants;
import com.customer.invite.model.Customer;
import com.customer.invite.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping("/getCustomerInRange")
    public List<Customer> getCustomerInRange() {
        List<Customer> customers=customerService.processCustomerData(AppConstants.JSON_FILE_INPUT_URL,AppConstants.DISTANCE_RANGE);
        return customers;
    }
}
