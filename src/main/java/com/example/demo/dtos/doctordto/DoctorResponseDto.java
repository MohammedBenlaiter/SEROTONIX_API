package com.example.demo.dtos.doctordto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorResponseDto {
    private Long doctorId;
    private String doctorType;
    private String clinicName;
    private String clinicAddress;
    private Long userId;
}