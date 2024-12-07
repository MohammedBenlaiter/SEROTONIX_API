package com.example.demo.services;

import org.springframework.stereotype.Service;
import com.example.demo.models.Operation;
import com.example.demo.repositories.OperationRepositories;

import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class OperationService {
    @Autowired
    private OperationRepositories operationRepository;

    public Operation createOperation(Operation operation) {
        return operationRepository.save(operation);
    }

    public Optional<Operation> getOperationById(Long id) {
        return operationRepository.findById(id);
    }

    public List<Operation> getAllOperations() {
        return operationRepository.findAll();
    }

    public Operation updateOperation(Long id, Operation operationDetails) {
        Operation operation = operationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Operation not found"));
        operation.setOperationDescription(operationDetails.getOperationDescription());
        operation.setOperationDate(operationDetails.getOperationDate());
        operation.setConsultation(operationDetails.getConsultation());
        return operationRepository.save(operation);
    }

    public void deleteOperation(Long id) {
        Operation operation = operationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Operation not found"));
        operationRepository.delete(operation);
    }

    public List<Operation> getOperationsByDate(LocalDate date) {
        return operationRepository.findByOperationDate(date);
    }
}
