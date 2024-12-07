package com.example.demo.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.repositories.PatientRepositories;
import com.example.demo.util.GenericMapper;
import com.example.demo.dtos.patientdto.PatientCreateDto;
import com.example.demo.dtos.patientdto.PatientResponseDto;
import com.example.demo.models.Patient;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepositories patientRepository;

    public List<PatientResponseDto> findAllPatients() {
        var patients = patientRepository.findAll();
        List<PatientResponseDto> patientResponseDtos = GenericMapper.mapCollection(patients, PatientResponseDto.class);
        return patientResponseDtos;
    }

    public Optional<PatientResponseDto> findPatientById(Long id) {
        var patient = patientRepository.findById(id);
        PatientResponseDto patientResponseDto = GenericMapper.map(patient, PatientResponseDto.class);
        return Optional.ofNullable(patientResponseDto);
    }

    public PatientResponseDto savePatient(PatientCreateDto patient) {
        Patient patientToSave = GenericMapper.map(patient, Patient.class);
        Patient savedPatient = patientRepository.save(patientToSave);
        PatientResponseDto patientResponseDto = GenericMapper.map(savedPatient, PatientResponseDto.class);
        return patientResponseDto;
    }

    public void deletePatientById(Long id) {
        patientRepository.deleteById(id);
    }

    public PatientResponseDto updatePatient(Long id, PatientCreateDto patientDetails) {
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Patient not found"));
        var result = GenericMapper.map(patientDetails, patient.getClass());
        Patient savedPatient = patientRepository.save(result);
        PatientResponseDto patientResponseDto = GenericMapper.map(savedPatient, PatientResponseDto.class);
        return patientResponseDto;
    }
}
