package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dtos.consultationdto.ConsultationCreateDto;
import com.example.demo.dtos.consultationdto.ConsultationResponseDto;
import com.example.demo.services.ConsultationService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/consultations")
public class ConsultationController {
    @Autowired
    private ConsultationService consultationService;

    @GetMapping
    public List<ConsultationResponseDto> getAllConsultations() {
        return consultationService.getAllConsultations();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultationResponseDto> getConsultationById(@PathVariable Long id) {
        Optional<ConsultationResponseDto> consultation = consultationService.getConsultationById(id);
        return consultation.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ConsultationResponseDto createConsultation(@RequestBody ConsultationCreateDto consultationCreateDto) {
        return consultationService.createConsultation(consultationCreateDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsultationResponseDto> updateConsultation(@PathVariable Long id,
            @RequestBody ConsultationCreateDto consultationDetails) {
        try {
            ConsultationResponseDto updatedConsultation = consultationService.updateConsultation(id, consultationDetails);
            return ResponseEntity.ok(updatedConsultation);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConsultation(@PathVariable Long id) {
        try {
            consultationService.deleteConsultation(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}