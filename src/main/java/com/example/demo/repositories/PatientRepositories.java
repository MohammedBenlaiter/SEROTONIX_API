package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Patient;

public interface PatientRepositories extends JpaRepository<Patient, Long> {

}