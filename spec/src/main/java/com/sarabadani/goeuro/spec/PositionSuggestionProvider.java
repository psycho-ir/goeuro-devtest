package com.sarabadani.goeuro.spec;

import com.sarabadani.goeuro.spec.vo.PositionSuggestion;

import java.util.List;

/**
 * The standard of all position suggestion providers.
 * Implementations should be able to return list of position suggestions which are correspond to passed town name.
 *
 * @author  Soroosh Sarabadani
 *
 */
public interface PositionSuggestionProvider {
    List<PositionSuggestion> provide(String townName);
}
