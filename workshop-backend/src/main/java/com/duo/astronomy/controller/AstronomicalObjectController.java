package com.duo.astronomy.controller;

import com.duo.astronomy.model.AstronomicalObject;
import com.duo.astronomy.repository.AstronomicalObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/objects")
public class AstronomicalObjectController {

    @Autowired
    private AstronomicalObjectRepository repository;

    @GetMapping
    public List<AstronomicalObject> getAllObjects() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<AstronomicalObject> getObjectById(@PathVariable int id) {
        return repository.findById(id);
    }

    @GetMapping("/type/{type}")
    public List<AstronomicalObject> getObjectsByType(@PathVariable String type) {
        return repository.findByType(type);
    }
}
