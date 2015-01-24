package com.sarabadani.goeuro.apiclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sarabadani.goeuro.apiclient.mixins.GeoPositionMixin;
import com.sarabadani.goeuro.apiclient.mixins.PositionSuggestionMixin;
import com.sarabadani.goeuro.spec.PositionSuggestionProvier;
import com.sarabadani.goeuro.spec.vo.GeoPosition;
import com.sarabadani.goeuro.spec.vo.PositionSuggestion;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by SOROOSH on 1/22/15.
 */
public class RestPositionSuggestionProvider implements PositionSuggestionProvier {


    @Override
    public List<PositionSuggestion> provide(String name) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.addMixIn(PositionSuggestion.class, PositionSuggestionMixin.class);
        mapper.addMixIn(GeoPosition.class, GeoPositionMixin.class);
        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
        messageConverter.setObjectMapper(mapper);
        List<HttpMessageConverter<?>> convertors = new ArrayList<HttpMessageConverter<?>>();
        convertors.add(messageConverter);

        RestTemplate template = new RestTemplate();
        template.setMessageConverters(convertors);
        final String url = String.format("http://api.goeuro.com/api/v2/position/suggest/en/%s", name);
        PositionSuggestion[] result = template.getForObject(url, PositionSuggestion[].class);
        System.out.println(Arrays.asList(result));
        return null;
    }

    public static void main(String[] args) {
        new RestPositionSuggestionProvider().provide("Berlin");
    }

}
