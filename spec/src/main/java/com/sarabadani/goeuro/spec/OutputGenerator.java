package com.sarabadani.goeuro.spec;

import com.sarabadani.goeuro.spec.vo.PositionSuggestion;

import java.util.List;


/**
 * The standard of all output generators.
 * Implementations should be able to return string data that is the representation of passed position suggestions.
 *
 * @author  Soroosh Sarabadani
 *
 */
public interface OutputGenerator {
    String generate(List<PositionSuggestion> positionSuggestion);
}
