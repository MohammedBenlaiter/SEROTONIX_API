package com.example.demo.dtos.userdto;

import lombok.Data;

@Data
public class ResponseUserDto {
    private Long id;
    private String username;
    private String email;
    private String password;
}