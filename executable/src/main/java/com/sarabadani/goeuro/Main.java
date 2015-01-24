package com.sarabadani.goeuro;

import com.sarabadani.goeuro.apiclient.RestPositionSuggestionProvider;
import com.sarabadani.goeuro.output.generator.csv.CSVOutputGenerator;
import com.sarabadani.goeuro.spec.OutputGenerator;
import com.sarabadani.goeuro.spec.PositionSuggestionProvier;
import com.sarabadani.goeuro.spec.vo.PositionSuggestion;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by soroosh on 1/24/15.
 */
public class Main {

    public static void main(String[] args) {
        try {
            final String cityName = validateArgs(args);
            final PositionSuggestionProvier suggestionProvier = new RestPositionSuggestionProvider();
            List<PositionSuggestion> suggestions = suggestionProvier.provide(cityName);
            checkFoundSuggestions(suggestions, cityName);
            final OutputGenerator outputGenerator = new CSVOutputGenerator();
            String generatedCSV = outputGenerator.generate(suggestions);

            try (FileWriter fileWriter = new FileWriter("default_output.csv")) {
                fileWriter.write(generatedCSV);
                fileWriter.flush();
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String validateArgs(String... args) {
        if (args.length != 1) {
            throw new IllegalArgumentException("Error! \r\nPlease just pass city name to jar file. \r\nExample:\r\n java -jar GoEuroTest.jar Berlin");
        }
        return args[0];
    }

    private static void checkFoundSuggestions(List<PositionSuggestion> suggestions, String cityName) {
        if (suggestions.size() == 0) {
            throw new IllegalArgumentException("Unfortunately no position have been found for " + cityName);
        }

    }
}
