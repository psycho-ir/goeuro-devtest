package com.sarabadani.goeuro.apiclient;

import com.sarabadani.goeuro.spec.PositionSuggestionProvider;
import com.sarabadani.goeuro.spec.vo.PositionSuggestion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


public class RestPositionSuggestionProviderTest {
    PositionSuggestionProvider provider;

    @Before
    public void setup() {
        provider = new RestPositionSuggestionProvider();
    }

    @Test
    public void provide_should_return_some_results_for_berlin() {
        List<PositionSuggestion> berlin = this.provider.provide("berlin");
        Assert.assertTrue(berlin.size() > 0);
    }



}