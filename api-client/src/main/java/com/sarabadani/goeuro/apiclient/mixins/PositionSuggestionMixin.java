package com.sarabadani.goeuro.apiclient.mixins;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sarabadani.goeuro.spec.vo.GeoPosition;

/**
 * Created by SOROOSH on 1/22/15.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class PositionSuggestionMixin {
    public PositionSuggestionMixin(@JsonProperty("_id") String id,
                                   @JsonProperty("key") String key,
                                   @JsonProperty("name") String name,
                                   @JsonProperty("fullName") String fullName,
                                   @JsonProperty("iata_airport_code") String iataAirPortCode,
                                   @JsonProperty("type") String type,
                                   @JsonProperty("country") String country,
                                   @JsonProperty("locationId") String locationId,
                                   @JsonProperty("geo_position")GeoPosition position) {
    }

}
