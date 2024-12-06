package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Consultation;

public interface ConsultationRepositories extends JpaRepository<Consultation, Long> {

}
