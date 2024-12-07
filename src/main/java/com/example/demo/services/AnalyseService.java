package com.example.demo.services;

import org.springframework.stereotype.Service;
import com.example.demo.models.Analyse;
import com.example.demo.repositories.AnalyseRepositories;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class AnalyseService {

    @Autowired
    private AnalyseRepositories analyseRepository;

    public List<Analyse> findAll() {
        return analyseRepository.findAll();
    }

    public Optional<Analyse> findById(Long id) {
        return analyseRepository.findById(id);
    }

    public Analyse save(Analyse analyse) {
        return analyseRepository.save(analyse);
    }

    public void deleteById(Long id) {
        analyseRepository.deleteById(id);
    }

    public Analyse updateAnalyse(Long id, Analyse analyseDetails) {
        Analyse analyse = analyseRepository.findById(id).orElseThrow(() -> new RuntimeException("Analyse not found"));
        analyse.setAnalyseType(analyseDetails.getAnalyseType());
        analyse.setAnalyseResult(analyseDetails.getAnalyseResult());
        analyse.setReview(analyseDetails.getReview());
        analyse.setAnalyseDescription(analyseDetails.getAnalyseDescription());
        analyse.setConsultation(analyseDetails.getConsultation());
        return analyseRepository.save(analyse);
    }
}
