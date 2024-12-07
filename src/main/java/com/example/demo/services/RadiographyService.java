package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.models.Radiography;
import com.example.demo.repositories.RadiographyRepositories;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class RadiographyService {
    @Autowired
    private RadiographyRepositories radiographyRepository;

    public List<Radiography> findAll() {
        return radiographyRepository.findAll();
    }

    public Optional<Radiography> findById(Long id) {
        return radiographyRepository.findById(id);
    }

    public Radiography save(Radiography radiography) {
        return radiographyRepository.save(radiography);
    }

    public void deleteById(Long id) {
        radiographyRepository.deleteById(id);
    }

    public Radiography updateRadiography(Long id, Radiography radiographyDetails) {
        Radiography radiography = radiographyRepository.findById(id)
                .orElseThrow();

        radiography.setRadiographyType(radiographyDetails.getRadiographyType());
        radiography.setRadiographyDate(radiographyDetails.getRadiographyDate());
        radiography.setRadiographyDescription(radiographyDetails.getRadiographyDescription());
        radiography.setRadiographyImage(radiographyDetails.getRadiographyImage());
        radiography.setConsultation(radiographyDetails.getConsultation());

        return radiographyRepository.save(radiography);
    }
}