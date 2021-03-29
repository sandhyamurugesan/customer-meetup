package com.customer.invite.model;


public class Customer {
    private int userId;
    private String userName;
    private GeoLocation geoLocation;
    private String distance;

    public Customer(){};

    public Customer(int userId, String userName, GeoLocation geoLocation) {
        this.userId = userId;
        this.userName = userName;
        this.geoLocation = geoLocation;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public GeoLocation getGeoLocation() {
        return geoLocation;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", distance=" + distance ;
    }
}
