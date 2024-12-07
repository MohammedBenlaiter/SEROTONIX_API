package com.example.demo.dtos.medicationdto;

import java.sql.Time;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicationResponseDto {
    private Long medicationId;
    private String medicationName;
    private Integer quantity;
    private String dosage;
    private String medicationType;
    private String medicationDescription;
    private Integer times;
    private Time duration;
    private Integer consumation;
    private Long prescriptionId;
}





/*


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicationResponseDto {
    private Long medicationId;
    private String medicationName;
    private Integer quantity;
    private String dosage;
    private String medicationType;
    private String medicationDescription;
    private Integer times;
    private Time duration;
    private Integer consumation;
    private Long prescriptionId;
} 
   


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicationCreateDto {
    private String medicationName;
    private Integer quantity;
    private String dosage;
    private String medicationType;
    private String medicationDescription;
    private Integer times;
    private Time duration;
    private Integer consumation;
    private Long prescriptionId;
}


*/