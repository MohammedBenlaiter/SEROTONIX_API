package com.example.demo.dtos.doctordto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorCreateDto {
    private String doctorType;
    private String clinicName;
    private String clinicAddress;
    private Long userId;
}
