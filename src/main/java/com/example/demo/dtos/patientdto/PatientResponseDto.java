package com.example.demo.dtos.patientdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientResponseDto {
    private Long patientId;
    private String patientType;
    private String firstChronicDisease;
    private String secondChronicDisease;
    private Long userId;
}
