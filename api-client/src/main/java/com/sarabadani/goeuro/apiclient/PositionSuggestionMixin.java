package com.sarabadani.goeuro.apiclient;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by SOROOSH on 1/22/15.
 */
public abstract class PositionSuggestionMixin {
    public PositionSuggestionMixin(@JsonProperty("_id") String id,
                                   @JsonProperty("key") String key,
                                   @JsonProperty("name") String name,
                                   @JsonProperty("fullName") String fullName,
                                   @JsonProperty("iata_air_port") String iataAirPort,
                                   @JsonProperty("type") String type,
                                   @JsonProperty("country") String country,
                                   @JsonProperty("locationId") String locationId) {
    }
//
//    @JsonProperty("_id")
//    public abstract String getId();
//
//    @JsonProperty("key")
//    public abstract String getKey();
//
//    @JsonProperty("name")
//    public abstract String getName();
//
//    @JsonProperty("fullName")
//    public abstract String getFullName();
//
//    @JsonProperty("iata_airport")
//    public abstract String getIataAirPort();
//
//    @JsonProperty("type")
//    public abstract String getType();
//
//    @JsonProperty("country")
//    public abstract String getCountry();
//
//    @JsonProperty("locationId")
//    public abstract String getLocationId();


}
