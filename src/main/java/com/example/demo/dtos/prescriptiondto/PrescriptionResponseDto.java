package com.example.demo.dtos.prescriptiondto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrescriptionResponseDto {
    private LocalDate date;
    private String description;
    private Long consultationId;
    private List<Long> medicationIds;
}
