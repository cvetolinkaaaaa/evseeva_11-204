package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        byte[] jsonData = Files.readAllBytes(new File("beers.txt").toPath());
        ObjectMapper objectMapper = new ObjectMapper();
        List<Beer> beers = objectMapper.readValue(jsonData, new TypeReference<List<Beer>>() {
        });
        List<Beer> strongBeers = beers.stream()
                .filter(beer -> beer.getAbv() > 5).toList();
        try (FileWriter writer = new FileWriter("strong_beers.txt")) {
            for (int i = 0; i < strongBeers.size(); i++) {
                writer.write((i + 1) + " - " + strongBeers.get(i).getName() + " - " + strongBeers.get(i).getTagline() + "\n");
            }
            System.out.println(beers);
        }
    }
}
