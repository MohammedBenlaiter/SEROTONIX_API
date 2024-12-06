package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Medication;

public interface MedicationRepositories extends JpaRepository<Medication, Long> {

}
