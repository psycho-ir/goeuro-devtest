package com.sarabadani.goeuro.spec;

import com.sarabadani.goeuro.spec.vo.PositionSuggestion;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created by SOROOSH on 1/22/15.
 */
public interface OutputGenerator {
    Stream generate(List<PositionSuggestion> positionSuggestion);
}
