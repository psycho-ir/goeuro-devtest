package com.sarabadani.goeuro;

import com.sarabadani.goeuro.spec.vo.PositionSuggestion;

import java.util.List;

/**
 * Created by soroosh on 1/25/15.
 */
public class Validator {
    public String validateArgs(String... args) {
        if (args.length != 1) {
            throw new IllegalArgumentException("Error! \r\nPlease just pass city name to jar file. \r\nExample:\r\n java -jar GoEuroTest.jar Berlin");
        }
        return args[0];
    }

    public void checkFoundSuggestions(List<PositionSuggestion> suggestions, String cityName) {
        if (cityName == null) {
            throw new IllegalArgumentException("Hah? city name is not defined!");
        }
        if (suggestions == null) {
            throw new IllegalArgumentException("Unfortunately no position have been found for " + cityName);
        }
        if (suggestions.size() == 0) {
            throw new IllegalArgumentException("Unfortunately no position have been found for " + cityName);
        }
    }

}

