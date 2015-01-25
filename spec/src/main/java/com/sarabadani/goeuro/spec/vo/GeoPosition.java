package com.sarabadani.goeuro.spec.vo;

/**
 * A Value object class to wrap geography positions.
 * This is a common class for Every implementation of specification.
 *
 * @author  Soroosh Sarabadani
  *
 */
public final class GeoPosition {

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
