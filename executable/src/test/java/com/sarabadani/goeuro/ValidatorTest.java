package com.sarabadani.goeuro;

import com.sarabadani.goeuro.spec.vo.PositionSuggestion;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class ValidatorTest {
    private Validator validator;


    @Before
    public void setup() {
        validator = new Validator();
    }

    @Test(expected = IllegalArgumentException.class)
    public void validator_should_throw_exception_when_number_of_inputs_is_zero() {
        validator.validateArgs();
    }

    @Test
    public void validator_should_do_nothing_when_arguments_are_one() {
        validator.validateArgs("input1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void validator_should_throw_exception_when_number_of_inputs_is_more_than_one() {
        validator.validateArgs("in1", "in2");
    }

    @Test(expected = IllegalArgumentException.class)
    public void validator_should_throw_exception_when_number_of_suggestions_is_zero() {
        validator.checkFoundSuggestions(new ArrayList<PositionSuggestion>(), "in1");
    }
    @Test(expected = IllegalArgumentException.class)
    public void validator_should_throw_exception_when_suggestions_is_null() {
        validator.checkFoundSuggestions(null, "in1");
    }
    @Test(expected = IllegalArgumentException.class)
    public void validator_should_throw_exception_when_cityname_is_null() {
        validator.checkFoundSuggestions(new ArrayList<PositionSuggestion>(), null);
    }

}