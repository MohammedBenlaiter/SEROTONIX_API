package com.example.demo.services;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.example.demo.dtos.medicationdto.MedicationCreateDto;
import com.example.demo.dtos.medicationdto.MedicationResponseDto;
import com.example.demo.models.Medication;
import com.example.demo.repositories.MedicationRepositories;
import com.example.demo.util.GenericMapper;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class MedicationService {

    @Autowired
    private MedicationRepositories medicationRepository;

    public List<MedicationResponseDto> findAll() {
        return GenericMapper.mapCollection(medicationRepository.findAll(), MedicationResponseDto.class);
    }

    public Optional<MedicationResponseDto> findById(Long id) {
        return medicationRepository.findById(id)
                .map(medication -> GenericMapper.map(medication, MedicationResponseDto.class));
    }

    public MedicationResponseDto save(MedicationCreateDto medicationCreateDto) {
        Medication medication = GenericMapper.map(medicationCreateDto, Medication.class);
        Medication savedMedication = medicationRepository.save(medication);
        return GenericMapper.map(savedMedication, MedicationResponseDto.class);
    }

    public void deleteById(Long id) {
        medicationRepository.deleteById(id);
    }

    public MedicationResponseDto updateMedication(Long id, MedicationCreateDto medicationDetails) {
        Medication medication = medicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medication not found"));
        var r = GenericMapper.map(medicationDetails, medication.getClass());
        Medication updatedMedication = medicationRepository.save(r);
        return GenericMapper.map(updatedMedication, MedicationResponseDto.class);
    }
}
