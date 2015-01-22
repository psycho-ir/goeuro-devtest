package com.sarabadani.goeuro.apiclient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by SOROOSH on 1/22/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PositionSuggestion {

    private final String id;
    private final String key;
    private final String name;
    private final String fullName;
    private final String iataAirPort;
    private final String type;
    private final String country;
    private final String locationId;


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

    public String getIataAirPort() {
        return iataAirPort;
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

    public PositionSuggestion(String id, String key, String name, String fullName, String iataAirPort, String type, String country, String locationId) {

        this.id = id;
        this.key = key;
        this.name = name;
        this.fullName = fullName;
        this.iataAirPort = iataAirPort;
        this.type = type;
        this.country = country;
        this.locationId = locationId;
    }


    @Override
    public String toString() {
        return "PositionSuggestion{" +
                "id='" + id + '\'' +
                ", key='" + key + '\'' +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", iataAirPort='" + iataAirPort + '\'' +
                ", type='" + type + '\'' +
                ", country='" + country + '\'' +
                ", locationId='" + locationId + '\'' +
                '}';
    }
}
