package com.sarabadani.goeuro.output.generator.csv;

import com.sarabadani.goeuro.spec.OutputGenerator;
import com.sarabadani.goeuro.spec.vo.GeoPosition;
import com.sarabadani.goeuro.spec.vo.PositionSuggestion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class CSVOutputGeneratorTest {
    PositionSuggestion suggestion = new PositionSuggestion("id", "key", "name", "fullName", "iata", "type", "country", "location", new GeoPosition("lat", "long"));
    OutputGenerator generator;

    @Before
    public void setup() {
        this.generator = new CSVOutputGenerator();

    }

    @Test
    public void generate_should_generate_expected_format() {
        Assert.assertEquals("id,name,type,lat,long\r\n", generator.generate(Arrays.asList(suggestion)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void generate_should_throw_exception_when_input_is_null() {
        generator.generate(null);
    }

}