package com.duo.astronomy.repository;

import com.duo.astronomy.model.AstronomicalObject;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class AstronomicalObjectRepository {
    private List<AstronomicalObject> objects;

    public AstronomicalObjectRepository() {
        loadObjectsFromFile();
    }

    // Methode om JSON-bestand te laden
    private void loadObjectsFromFile() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            File file = new File("src/main/resources/astronomical_objects_sorted_25.json");
            objects = mapper.readValue(file, new TypeReference<List<AstronomicalObject>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<AstronomicalObject> findAll() {
        System.out.println("Aantal objecten geladen: " + objects.size());
        return objects;
    }

    public Optional<AstronomicalObject> findById(int id) {
        return objects.stream().filter(obj -> obj.getId() == id).findFirst();
    }

    public List<AstronomicalObject> findByType(String type) {
        return objects.stream().filter(obj -> obj.getType().equalsIgnoreCase(type)).collect(Collectors.toList());
    }
}
