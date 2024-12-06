package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Operation;

public interface OperationRepositories extends JpaRepository<Operation , Long>{

}
