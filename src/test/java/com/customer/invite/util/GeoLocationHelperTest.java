package com.customer.invite.util;

import com.customer.invite.model.GeoLocation;
import com.customer.invite.util.GeoLocationHelper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeoLocationHelperTest {

    @Test
    public void getDistanceInKm() {
        GeoLocation location1 = new GeoLocation(300d, -100d);
        GeoLocation location2 = new GeoLocation(-500d, 100d);
        Double expectedDistance = 2620.528285755069;
        System.out.println(GeoLocationHelper.getDistanceInKm(location1,location2));
        assertEquals(0, expectedDistance.compareTo(GeoLocationHelper.getDistanceInKm(location1,location2)));

    }

}