package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.prescriptiondto.PrescriptionCreateDto;
import com.example.demo.dtos.prescriptiondto.PrescriptionResponseDto;
import com.example.demo.services.PrescriptionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/prescription")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    @GetMapping
    public List<PrescriptionResponseDto> getAllPrescriptions() {
        return prescriptionService.getAllPrescriptions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrescriptionResponseDto> getPrescriptionById(@PathVariable Long id) {
        Optional<PrescriptionResponseDto> prescription = prescriptionService.getPrescriptionById(id);
        return prescription.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PrescriptionResponseDto> createPrescription(
            @RequestBody PrescriptionCreateDto prescriptionCreateDto) {
        PrescriptionResponseDto createdPrescription = prescriptionService.savePrescription(prescriptionCreateDto);
        return ResponseEntity.ok(createdPrescription);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PrescriptionResponseDto> updatePrescription(@PathVariable Long id,
            @RequestBody PrescriptionCreateDto prescriptionDetails) {
        PrescriptionResponseDto updatedPrescription = prescriptionService.updatePrescription(id, prescriptionDetails);
        return ResponseEntity.ok(updatedPrescription);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrescription(@PathVariable Long id) {
        prescriptionService.deletePrescription(id);
        return ResponseEntity.noContent().build();
    }
}