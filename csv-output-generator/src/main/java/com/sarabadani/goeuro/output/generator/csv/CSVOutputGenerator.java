package com.sarabadani.goeuro.output.generator.csv;

import com.sarabadani.goeuro.spec.OutputGenerator;
import com.sarabadani.goeuro.spec.vo.PositionSuggestion;
import org.supercsv.io.dozer.CsvDozerBeanWriter;
import org.supercsv.io.dozer.ICsvDozerBeanWriter;
import org.supercsv.prefs.CsvPreference;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.util.List;

/**
 * CSV Generator implementation of {@link com.sarabadani.goeuro.spec.OutputGenerator}.
 * This implementation uses supercsv dozer to generate CSV format.
 *
 * @author  Soroosh Sarabadani
 * @see com.sarabadani.goeuro.spec.OutputGenerator
 *
 */

public class CSVOutputGenerator implements OutputGenerator {

    /**
     *
     * @param positionSuggestions List of suggested positions
     * @return a String contains CSV format of suggested positions
     * @throws java.lang.IllegalArgumentException when positionSuggestions is null
     */
    @Override
    public String generate(List<PositionSuggestion> positionSuggestions) {
        if (positionSuggestions == null){
            throw new IllegalArgumentException("Position suggestions cannot be null.");
        }
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        try (ICsvDozerBeanWriter writer = new CsvDozerBeanWriter(charArrayWriter, CsvPreference.STANDARD_PREFERENCE)) {
            writer.configureBeanMapping(PositionSuggestion.class, new String[]{"id", "name", "type", "position.latitude", "position.longitude"});
            for (PositionSuggestion position : positionSuggestions) {
                writer.write(position);
            }
            writer.flush();
        } catch (IOException e) {
            // IOException never happen with our circumstances
            e.printStackTrace();
        }

        return charArrayWriter.toString();

    }

}
