package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.dtos.medicationdto.MedicationCreateDto;
import com.example.demo.dtos.medicationdto.MedicationResponseDto;
import com.example.demo.services.MedicationService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/medications")
public class MedicationController {

    @Autowired
    private MedicationService medicationService;

    @GetMapping
    public List<MedicationResponseDto> getAllMedications() {
        return medicationService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicationResponseDto> getMedicationById(@PathVariable Long id) {
        Optional<MedicationResponseDto> medication = medicationService.findById(id);
        return medication.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public MedicationResponseDto createMedication(@RequestBody MedicationCreateDto medicationCreateDto) {
        return medicationService.save(medicationCreateDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicationResponseDto> updateMedication(@PathVariable Long id,
            @RequestBody MedicationCreateDto medicationDetails) {
        try {
            MedicationResponseDto updatedMedication = medicationService.updateMedication(id, medicationDetails);
            return ResponseEntity.ok(updatedMedication);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedication(@PathVariable Long id) {
        medicationService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
