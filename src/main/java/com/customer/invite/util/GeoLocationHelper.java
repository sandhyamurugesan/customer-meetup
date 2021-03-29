package com.customer.invite.util;

import com.customer.invite.model.GeoLocation;

public class GeoLocationHelper {
    public static double getDistanceInKm(GeoLocation location1, GeoLocation location2) {

        final double R = 6371.009; // Radius of the earth

        double lonDistance = Math.toRadians(location2.getLongitude() - location1.getLongitude());
        double centralAngle = Math.acos(Math.sin(Math.toRadians(location1.getLatitude())) * Math.sin(Math.toRadians(location2.getLatitude()))
                + Math.cos(Math.toRadians(location1.getLatitude())) * Math.cos(Math.toRadians(location2.getLatitude()))
                * Math.cos(lonDistance));
        double distance=R * centralAngle; //Central angle calculated from the first formula from wikipedia page: https://en.wikipedia.org/wiki/Great-circle_distance

        return distance;
    }
}
