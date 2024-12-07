package com.example.demo.services;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dtos.prescriptiondto.PrescriptionCreateDto;
import com.example.demo.dtos.prescriptiondto.PrescriptionResponseDto;
import com.example.demo.models.Prescription;
import com.example.demo.repositories.PrescriptionRepositories;
import com.example.demo.util.GenericMapper;

@Service
public class PrescriptionService {
    @Autowired
    private PrescriptionRepositories prescriptionRepository;

    public List<PrescriptionResponseDto> getAllPrescriptions() {
        List<Prescription> p = (List<Prescription>) prescriptionRepository.findAll();

        List<PrescriptionResponseDto> dto = GenericMapper.mapCollection(p, PrescriptionResponseDto.class);

        return dto;
    }

    public Optional<PrescriptionResponseDto> getPrescriptionById(Long id) {
        Optional<Prescription> result = prescriptionRepository.findById(id);

        return result.map(prescription -> GenericMapper.map(prescription, PrescriptionResponseDto.class));
    }

    public PrescriptionResponseDto savePrescription(PrescriptionCreateDto prescription) {
        Prescription entity = GenericMapper.map(prescription, Prescription.class);
        entity = prescriptionRepository.save(entity);
        return GenericMapper.map(entity, PrescriptionResponseDto.class);
    }

    public void deletePrescription(Long id) {
        prescriptionRepository.deleteById(id);
    }

    public PrescriptionResponseDto updatePrescription(Long id, PrescriptionCreateDto prescriptionDetails) {
        Prescription prescription = prescriptionRepository.findById(id)
                .orElseThrow();

        GenericMapper.map(prescriptionDetails, prescription.getClass());
        final Prescription updatedPrescription = prescriptionRepository.save(prescription);
        return GenericMapper.map(updatedPrescription, PrescriptionResponseDto.class);
    }
}
