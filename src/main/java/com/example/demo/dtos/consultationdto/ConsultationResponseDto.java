package com.example.demo.dtos.consultationdto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsultationResponseDto {
    private Long consultationId;
    private LocalDate consultationDate;
    private String consultationReason;
    private Long patientId;
    private Long doctorId;
    private Long prescriptionId;
}