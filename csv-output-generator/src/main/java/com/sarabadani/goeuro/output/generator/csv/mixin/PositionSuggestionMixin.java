package com.sarabadani.goeuro.output.generator.csv.mixin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by soroosh on 1/24/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class PositionSuggestionMixin {
    @JsonProperty("ID")
    public String _id;
    @JsonProperty("name")
    public String name;
    public String type;
    public String latitude;
    public String longitude;
    @JsonProperty("country")
    public String country;

}
