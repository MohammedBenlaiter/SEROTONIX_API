package com.example.demo.services;

import com.example.demo.dtos.consultationdto.ConsultationCreateDto;
import com.example.demo.dtos.consultationdto.ConsultationResponseDto;
import com.example.demo.models.Consultation;
import com.example.demo.repositories.ConsultationRepositories;
import com.example.demo.util.GenericMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultationService {

    @Autowired
    private ConsultationRepositories consultationRepository;

    public List<ConsultationResponseDto> getAllConsultations() {
        return GenericMapper.mapCollection(consultationRepository.findAll(), ConsultationResponseDto.class);
    }

    public Optional<ConsultationResponseDto> getConsultationById(Long id) {
        return consultationRepository.findById(id)
                .map(consultation -> GenericMapper.map(consultation, ConsultationResponseDto.class));
    }

    public ConsultationResponseDto createConsultation(ConsultationCreateDto consultationCreateDto) {
        Consultation consultation = GenericMapper.map(consultationCreateDto, Consultation.class);
        Consultation savedConsultation = consultationRepository.save(consultation);
        return GenericMapper.map(savedConsultation, ConsultationResponseDto.class);
    }

    public ConsultationResponseDto updateConsultation(Long id, ConsultationCreateDto consultationDetails) {
        Consultation consultation = consultationRepository.findById(id)
                .orElseThrow();

        var res = GenericMapper.map(consultationDetails, consultation.getClass());

        Consultation updatedConsultation = consultationRepository.save(res);
        ConsultationResponseDto dto = GenericMapper.map(updatedConsultation, ConsultationResponseDto.class);
        return dto;
    }

    public void deleteConsultation(Long id) {
        Consultation consultation = consultationRepository.findById(id)
                .orElseThrow();
        consultationRepository.delete(consultation);
    }
}
