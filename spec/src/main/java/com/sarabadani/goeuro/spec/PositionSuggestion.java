package com.sarabadani.goeuro.spec;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by SOROOSH on 1/22/15.
 */
//@JsonIgnoreProperties(ignoreUnknown = true)
public class PositionSuggestion {
    public String _id;
    public String key;
    public String name;
    public String fullName;
    public String iata_airport_code;
    public String type;
    public String country;
    public String locationId;

    @Override
    public String toString() {
        return "PositionSuggestion{" +
                "_id='" + _id + '\'' +
                ", key='" + key + '\'' +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", iata_airport_code='" + iata_airport_code + '\'' +
                ", type='" + type + '\'' +
                ", country='" + country + '\'' +
                ", locationId='" + locationId + '\'' +
                "}";
    }
}
