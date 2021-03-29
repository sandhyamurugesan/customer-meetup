package com.customer.invite.util;


import com.customer.invite.model.Customer;
import com.customer.invite.util.FileReader;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileReaderTest {

    @Test
    public void getCustomers() throws IOException {

        String mockInputJson = "{\"latitude\": \"52.986375\", \"user_id\": 15, \"name\": \"Nikita McArdle\", \"longitude\": \"-5.043701\"}\n" +
                "{\"latitude\": \"51.92893\", \"user_id\": 11, \"name\": \"Dora Schembk\", \"longitude\": \"-9.27699\"}\n" +
                "{\"latitude\": \"51.8856167\", \"user_id\": 6, \"name\": \"David Dolan\", \"longitude\": \"-9.4240951\"}\n" +
                "{\"latitude\": \"52.3191841\", \"user_id\": 5, \"name\": \"Harry Duncan\", \"longitude\": \"-7.5072391\"}";

        InputStream inputStream = new ByteArrayInputStream(mockInputJson.getBytes(StandardCharsets.UTF_8));

        List<Customer> customers = FileReader.getCustomers(inputStream);

        assert (customers.size() == 4);

    }

    @Test
    public void getCustomersListFromJsonList() throws JSONException {

        List<JSONObject> customerJsonObjects = new ArrayList<>();

        customerJsonObjects.add(new JSONObject("{\"latitude\": \"53.4692815\", \"user_id\": 4, \"name\": \"Gunjan Pathak\", \"longitude\": \"-9.436036\"}"));
        customerJsonObjects.add(new JSONObject("{\"latitude\": \"54.080556\", \"user_id\": 12, \"name\": \"Harry Duncan\", \"longitude\": \"-6.361944\"}"));
        customerJsonObjects.add(new JSONObject("{\"latitude\": \"53.521111\", \"user_id\": 14, \"name\": \"Conor Flahive\", \"longitude\": \"-9.831111\"}"));
        
        List<Customer> customers = FileReader.getCustomersListFromJsonList(customerJsonObjects);

        assertEquals(3, customers.size());
        assertEquals(4, customers.get(0).getUserId());
        assertEquals("Harry Duncan", customers.get(1).getUserName());
        assertEquals(0d, Double.compare(53.521111d, customers.get(2).getGeoLocation().getLatitude()) );
        assertEquals(0d, Double.compare(-9.831111d, customers.get(2).getGeoLocation().getLongitude()) );

    }
}