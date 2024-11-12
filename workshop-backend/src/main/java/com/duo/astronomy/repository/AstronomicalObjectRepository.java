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

    // Load objects from a JSON-file
    private void loadObjectsFromFile() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            File file = new File("src/main/resources/astronomical_objects_sorted_25.json");
            objects = mapper.readValue(file, new TypeReference<List<AstronomicalObject>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Find all objects
    public List<AstronomicalObject> findAll() {
        System.out.println("Aantal objecten geladen: " + objects.size());
        return objects;
    }

    // Find an object of a specific ID
    public Optional<AstronomicalObject> findById(int id) {
        return objects.stream().filter(obj -> obj.getId() == id).findFirst();
    }

    // Find an object of a specific type
    public List<AstronomicalObject> findByType(String type) {
        return objects.stream().filter(obj -> obj.getType().equalsIgnoreCase(type)).collect(Collectors.toList());
    }

    // Add a new object
    public AstronomicalObject addObject(AstronomicalObject newObject) {
        newObject.setId(generateNewId());
        objects.add(newObject);
        return newObject;
    }

    // Update an existing object
    public AstronomicalObject updateObject(int id, AstronomicalObject updatedObject) {
        for (int i = 0; i < objects.size(); i++) {
            if (objects.get(i).getId() == id) {
                updatedObject.setId(id);
                objects.set(i, updatedObject);
                return updatedObject;
            }
        }
        return null;
    }

    // Delete an object of a specific id
    public boolean deleteObject(int id) {
        return objects.removeIf(obj -> obj.getId() == id);
    }

    // Generate a new ID for a new object
    private int generateNewId() {
        return objects.stream()
                .mapToInt(AstronomicalObject::getId)
                .max()
                .orElse(0) + 1;
    }
}
