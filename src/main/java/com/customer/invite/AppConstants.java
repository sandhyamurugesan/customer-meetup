package com.customer.invite;

import com.customer.invite.model.GeoLocation;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class AppConstants {

    public static final String JSON_FILE_INPUT_URL="https://s3.amazonaws.com/intercom-take-home-test/customers.txt";
    public static final Charset JSON_TXT_FILE_ENCODING = StandardCharsets.UTF_8;

    public static final String JSON_ATTR_USER_ID="user_id";
    public static final String JSON_ATTR_USER_NAME="name";
    public static final String JSON_ATTR_LATITUDE="latitude";
    public static final String JSON_ATTR_LONGITUDE="longitude";

    public static final GeoLocation DUBLIN_OFFICE_GPS_COORDINATE = new GeoLocation(53.339428,-6.257664);
    public static final Double DISTANCE_RANGE=100d;

    public static final String KM_STRING="Km";


}
