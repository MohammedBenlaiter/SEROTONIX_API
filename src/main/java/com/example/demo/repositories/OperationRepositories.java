package com.example.demo.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Operation;

public interface OperationRepositories extends JpaRepository<Operation, Long> {
    List<Operation> findByOperationDate(LocalDate date);
}
