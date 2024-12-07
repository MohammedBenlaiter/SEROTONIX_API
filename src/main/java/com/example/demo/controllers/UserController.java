package com.example.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.JwtResponseDto;
import com.example.demo.dtos.userdto.CreateUserDto;
import com.example.demo.dtos.userdto.UserLoginDto;
import com.example.demo.services.AuthService;
import com.example.demo.services.UserService;
import com.example.demo.util.JwtUtil;

@RestController
@RequestMapping("api/user")
public class UserController {

    private UserService userService;
    private AuthService authService;

    public UserController(UserService userService, AuthService authService) {
        this.userService = userService;
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponseDto> login(@RequestBody UserLoginDto createUserDto) {
        String token = authService.authenticate(createUserDto);
        return ResponseEntity.ok(new JwtResponseDto(token));
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody CreateUserDto createUserDto) {
        return ResponseEntity.ok().body(userService.creatUser(createUserDto));
    }

    @GetMapping("/validate")
    public ResponseEntity<Long> validateToken(@RequestHeader("Authorization") String token) {
        String username = JwtUtil.extractUsername(token.substring(7)); // Remove "Bearer " prefix
        Long userId = userService.getUserId(username);
        return ResponseEntity.ok().body(userId);
    }

    @GetMapping("/delete")
    public ResponseEntity<String> deleteUser(@RequestHeader("Authorization") String token) {
        String username = JwtUtil.extractUsername(token.substring(7)); // Remove "Bearer " prefix
        return ResponseEntity.ok().body(userService.deleteUser(username));
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateUser(@RequestHeader("Authorization") String token, @RequestBody CreateUserDto createUserDto) {
        String username = JwtUtil.extractUsername(token.substring(7)); // Remove "Bearer " prefix
        return ResponseEntity.ok().body(userService.updateUser(username, createUserDto));
    }
}