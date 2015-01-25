package com.sarabadani.goeuro.apiclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sarabadani.goeuro.apiclient.mixins.GeoPositionMixin;
import com.sarabadani.goeuro.apiclient.mixins.PositionSuggestionMixin;
import com.sarabadani.goeuro.spec.PositionSuggestionProvider;
import com.sarabadani.goeuro.spec.vo.GeoPosition;
import com.sarabadani.goeuro.spec.vo.PositionSuggestion;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Rest Position Suggestionimplementation of {@link com.sarabadani.goeuro.spec.PositionSuggestionProvider}.
 * This implementation uses Spring Rest Template to communicate with Rest API (http://api.goeuro.com/api/v2/position/suggest/en/{CITY_NAME})
 *
 * @author Soroosh Sarabadani
 * @see com.sarabadani.goeuro.spec.OutputGenerator
 */
public class RestPositionSuggestionProvider implements PositionSuggestionProvider {
    private final ObjectMapper mapper = new ObjectMapper();
    private final RestTemplate template;
    private final String apiUrl;
    //todo: Making API_URL configurable (eg. by using properties file) is a good practice. But i think it is not needed for this task.
    private static final String API_URL = "http://api.goeuro.com/api/v2/position/suggest/en/%s";

    public RestPositionSuggestionProvider() {
        this.apiUrl = API_URL;
        mapper.addMixIn(PositionSuggestion.class, PositionSuggestionMixin.class);
        mapper.addMixIn(GeoPosition.class, GeoPositionMixin.class);
        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
        messageConverter.setObjectMapper(mapper);
        List<HttpMessageConverter<?>> convertors = new ArrayList<HttpMessageConverter<?>>();
        convertors.add(messageConverter);
        this.template = new RestTemplate();
        template.setMessageConverters(convertors);
    }

    public RestPositionSuggestionProvider(String apiUrl) {

        if (apiUrl == null) {
            throw new IllegalArgumentException("apiUrl cannot be null");
        }
        this.apiUrl = API_URL;

        mapper.addMixIn(PositionSuggestion.class, PositionSuggestionMixin.class);
        mapper.addMixIn(GeoPosition.class, GeoPositionMixin.class);
        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
        messageConverter.setObjectMapper(mapper);
        List<HttpMessageConverter<?>> convertors = new ArrayList<HttpMessageConverter<?>>();
        convertors.add(messageConverter);

        this.template = new RestTemplate();
        template.setMessageConverters(convertors);
    }


    @Override
    public List<PositionSuggestion> provide(String name) {
        final String url = String.format(this.apiUrl, name);
        PositionSuggestion[] result = template.getForObject(url, PositionSuggestion[].class);
        return Arrays.asList(result);
    }
}
