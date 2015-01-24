package com.sarabadani.goeuro.apiclient.mixins;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by soroosh on 1/24/15.
 */
public abstract class GeoPositionMixin {
    public GeoPositionMixin(@JsonProperty("latitude") String latitude, @JsonProperty("longtitude") String longtitude) {
    }
}
