package com.sarabadani.goeuro.apiclient;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.*;


/**
 * Created by SOROOSH on 1/22/15.
 */
public class Client {
    public static void main(String[] args) {
        RestTemplate template = new RestTemplate();
        PositionSuggestion[] result = template.getForObject("http://api.goeuro.com/api/v2/position/suggest/en/Berlin", PositionSuggestion[].class);
        System.out.println(Arrays.asList(result));
    }
}
