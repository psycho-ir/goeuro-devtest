package com.sarabadani.goeuro;

import com.sarabadani.goeuro.apiclient.RestPositionSuggestionProvider;
import com.sarabadani.goeuro.output.generator.csv.CSVOutputGenerator;
import com.sarabadani.goeuro.spec.OutputGenerator;
import com.sarabadani.goeuro.spec.PositionSuggestionProvider;
import com.sarabadani.goeuro.spec.vo.PositionSuggestion;
import org.springframework.web.client.RestClientException;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by soroosh on 1/24/15.
 */
public class Main {

    private final static Validator validator = new Validator();

    public static void main(String[] args) {
        try {
            final String cityName = validator.validateArgs(args);
            final PositionSuggestionProvider suggestionProvider = new RestPositionSuggestionProvider();
            List<PositionSuggestion> suggestions = suggestionProvider.provide(cityName);
            validator.checkFoundSuggestions(suggestions, cityName);
            final OutputGenerator outputGenerator = new CSVOutputGenerator();
            String generatedCSV = outputGenerator.generate(suggestions);

            try (FileWriter fileWriter = new FileWriter("default_output.csv")) {
                fileWriter.write(generatedCSV);
                fileWriter.flush();
                System.out.println("Ths CSV file generated. CSV_File_Name: default_output.csv");
            }
        } catch (IllegalArgumentException | IOException | RestClientException e) {
            System.err.println(e.getMessage());
        }

    }


}
