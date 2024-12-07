package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

import com.example.demo.dtos.patientdto.PatientCreateDto;
import com.example.demo.dtos.patientdto.PatientResponseDto;
import com.example.demo.services.PatientService;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping
    public List<PatientResponseDto> getAllPatients() {
        return patientService.findAllPatients();
    }

    @GetMapping("/{id}")
    public PatientResponseDto getPatientById(@PathVariable Long id) {
        return patientService.findPatientById(id).orElseThrow(() -> new RuntimeException("Patient not found"));
    }

    @PostMapping
    public PatientResponseDto createPatient(@RequestBody PatientCreateDto patient) {
        return patientService.savePatient(patient);
    }

    @PutMapping("/{id}")
    public PatientResponseDto updatePatient(@PathVariable Long id, @RequestBody PatientCreateDto patientDetails) {
        return patientService.updatePatient(id, patientDetails);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        patientService.deletePatientById(id);
    }
}