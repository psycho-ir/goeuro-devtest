package com.sarabadani.goeuro.spec;

import com.sarabadani.goeuro.spec.vo.PositionSuggestion;

import java.util.List;

/**
 * Created by SOROOSH on 1/22/15.
 */
public interface PositionSuggestionProvier {
    List<PositionSuggestion> provide(String townName);
}
