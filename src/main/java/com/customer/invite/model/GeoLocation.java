package com.customer.invite.model;

public class GeoLocation {

    private double latitude;
    private double longitude;

    public GeoLocation(){}
    public GeoLocation(Double latitude,Double longitude){
        this.latitude=latitude;
        this.longitude=longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString(){
        return "latitude: " + latitude + ", longitude: " + longitude;
    }

}
