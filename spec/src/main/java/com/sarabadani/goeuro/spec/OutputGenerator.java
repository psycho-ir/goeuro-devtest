package com.sarabadani.goeuro.spec;

import java.io.InputStream;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by SOROOSH on 1/22/15.
 */
public interface OutputGenerator {
    Stream generate(List<PositionSuggestion> positionSuggestion);
}
