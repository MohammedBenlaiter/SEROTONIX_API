package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.models.Radiography;
import com.example.demo.services.RadiographyService;
import java.util.List;

@RestController
@RequestMapping("/radiographies")
public class RadioController {

    @Autowired
    private RadiographyService radiographyService;

    @GetMapping
    public List<Radiography> getAllRadiographies() {
        return radiographyService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Radiography> getRadiographyById(@PathVariable Long id) {
        return radiographyService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Radiography createRadiography(@RequestBody Radiography radiography) {
        return radiographyService.save(radiography);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Radiography> updateRadiography(@PathVariable Long id,
            @RequestBody Radiography radiographyDetails) {
        return ResponseEntity.ok(radiographyService.updateRadiography(id, radiographyDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRadiography(@PathVariable Long id) {
        radiographyService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}