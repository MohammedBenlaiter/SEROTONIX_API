package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.models.Analyse;
import com.example.demo.services.AnalyseService;

import java.util.List;

@RestController
@RequestMapping("/api/analyses")
public class AnalyseController {

    @Autowired
    private AnalyseService analyseService;

    @GetMapping
    public List<Analyse> getAllAnalyses() {
        return analyseService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Analyse> getAnalyseById(@PathVariable Long id) {
        java.util.Optional<Analyse> analyse = analyseService.findById(id);
        return analyse.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Analyse createAnalyse(@RequestBody Analyse analyse) {
        return analyseService.save(analyse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Analyse> updateAnalyse(@PathVariable Long id, @RequestBody Analyse analyseDetails) {
        try {
            Analyse updatedAnalyse = analyseService.updateAnalyse(id, analyseDetails);
            return ResponseEntity.ok(updatedAnalyse);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnalyse(@PathVariable Long id) {
        analyseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
