package com.sarabadani.goeuro.spec.vo;

/**
 * Created by soroosh on 1/24/15.
 */
public class GeoPosition {

    private final String latitude;
    private final String longitude;

    public GeoPosition(String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return "GeoPosition{" +
                "latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }
}
