package com.duo.astronomy.controller;

import com.duo.astronomy.model.AstronomicalObject;
import com.duo.astronomy.repository.AstronomicalObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/objects")
@CrossOrigin(origins = "http://localhost:4200")
public class AstronomicalObjectController {

    @Autowired
    private AstronomicalObjectRepository repository;

    // GET: Get all objects
    @GetMapping
    public List<AstronomicalObject> getAllObjects() {
        return repository.findAll();
    }

    // GET: Get an object with a specific id
    @GetMapping("/{id}")
    public Optional<AstronomicalObject> getObjectById(@PathVariable int id) {
        return repository.findById(id);
    }

    // GET: Get an object of a specific type
    @GetMapping("/type/{type}")
    public List<AstronomicalObject> getObjectsByType(@PathVariable String type) {
        return repository.findByType(type);
    }

    // POST: Add a new object
    @PostMapping
    public AstronomicalObject addObject(@RequestBody AstronomicalObject newObject) {
        return repository.addObject(newObject);
    }

    // PUT: Update an existing object
    @PutMapping("/{id}")
    public AstronomicalObject updateObject(@PathVariable int id, @RequestBody AstronomicalObject updatedObject) {
        return repository.updateObject(id, updatedObject);
    }

    // DELETE: Delete an object of a specific id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteObject(@PathVariable int id) {
        boolean isDeleted = repository.deleteObject(id);
        if (isDeleted) {
            return ResponseEntity.ok("Object met id " + id + " is verwijderd.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Object met id " + id + " niet gevonden.");
        }
    }
}
