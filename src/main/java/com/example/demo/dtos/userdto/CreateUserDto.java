package com.example.demo.dtos.userdto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CreateUserDto {
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private LocalDate birthDate;
    private byte[] picture;
}