package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.models.Operation;
import com.example.demo.services.OperationService;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class OperationController {

    @Autowired
    private OperationService operationService;

    @PostMapping
    public Operation createOperation(@RequestBody Operation operation) {
        return operationService.createOperation(operation);
    }

    @GetMapping("/{id}")
    public Optional<Operation> getOperationById(@PathVariable Long id) {
        return operationService.getOperationById(id);
    }

    @GetMapping
    public List<Operation> getAllOperations() {
        return operationService.getAllOperations();
    }

    @PutMapping("/{id}")
    public Operation updateOperation(@PathVariable Long id, @RequestBody Operation operationDetails) {
        return operationService.updateOperation(id, operationDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteOperation(@PathVariable Long id) {
        operationService.deleteOperation(id);
    }

    @GetMapping("/date/{date}")
    public List<Operation> getOperationsByDate(@PathVariable LocalDate date) {
        return operationService.getOperationsByDate(date);
    }
}