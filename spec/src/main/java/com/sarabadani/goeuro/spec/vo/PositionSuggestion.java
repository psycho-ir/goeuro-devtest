package com.sarabadani.goeuro.spec.vo;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by SOROOSH on 1/22/15.
 */

public class PositionSuggestion {
    private final String id;
    private final String key;
    private final String name;
    private final String fullName;
    private final String iataAirPortCode;
    private final String type;
    private final String country;
    private final String locationId;
    private final GeoPosition position;

    public String getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public String getIataAirPortCode() {
        return iataAirPortCode;
    }

    public String getType() {
        return type;
    }

    public String getCountry() {
        return country;
    }

    public String getLocationId() {
        return locationId;
    }

    public GeoPosition getPosition() { return position; }

    public PositionSuggestion(String id, String key, String name, String fullName, String iataAirPortCode, String type, String country, String locationId, GeoPosition position) {
        this.id = id;
        this.key = key;
        this.name = name;
        this.fullName = fullName;
        this.iataAirPortCode = iataAirPortCode;
        this.type = type;
        this.country = country;
        this.locationId = locationId;
        this.position = position;
    }

    @Override
    public String toString() {
        return "PositionSuggestion{" +
                "id='" + id + '\'' +
                ", key='" + key + '\'' +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", iataAirPortCode='" + iataAirPortCode + '\'' +
                ", type='" + type + '\'' +
                ", country='" + country + '\'' +
                ", locationId='" + locationId + '\'' +
                ", postion= '" + position.toString() + '\'' +
                '}';
    }
}
