package com.example.demo.dtos.userdto;

import lombok.Data;

@Data
public class CreateUserDto {
    private String username;
    private String password;
    private String email;
}