package com.example.demo.dtos.patientdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientCreateDto {
    private String patientType;
    private String firstChronicDisease;
    private String secondChronicDisease;
    private Long userId;
}
