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
 * Created by soroosh on 1/24/15.
 */
public class CSVOutputGenerator implements OutputGenerator {
    @Override
    public String generate(List<PositionSuggestion> positionSuggestions) {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        try (ICsvDozerBeanWriter writer = new CsvDozerBeanWriter(charArrayWriter, CsvPreference.STANDARD_PREFERENCE)) {
            writer.configureBeanMapping(PositionSuggestion.class, new String[]{"id", "name", "type", "position.latitude", "position.longitude"});
            for (PositionSuggestion position : positionSuggestions) {
                writer.write(position);
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return charArrayWriter.toString();

    }

}
