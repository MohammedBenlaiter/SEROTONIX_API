package com.example.demo.services;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;
import com.example.demo.dtos.userdto.UserLoginDto;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRepositories;
import com.example.demo.util.JwtUtil;

@Service
public class AuthService {
    private UserRepositories userRepositories;

    public AuthService(UserRepositories userRepositories) {
        this.userRepositories = userRepositories;
    }

    public String authenticate(UserLoginDto userDto) {
        User user = userRepositories.findByUsername(userDto.getUsername());
        if (ObjectUtils.isEmpty(user) || !user.getPassword().equals(userDto.getPassword())) {
            throw new RuntimeException("Invalid Username or Password");
        }
        return JwtUtil.generateToken(user.getUsername());
    }
    

    public User register(User user) {
        if (userRepositories.findByUsername(user.getUsername()) != null
                || userRepositories.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("User already exists");
        }
        return userRepositories.save(user);
    }
}
