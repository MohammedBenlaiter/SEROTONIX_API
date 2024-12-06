package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Prescription;

public interface PrescriptionRepositories extends JpaRepository<Prescription, Long> {

}
