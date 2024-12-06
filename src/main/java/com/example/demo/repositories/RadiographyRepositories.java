package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Radiography;

public interface RadiographyRepositories extends JpaRepository<Radiography, Long> {

}
