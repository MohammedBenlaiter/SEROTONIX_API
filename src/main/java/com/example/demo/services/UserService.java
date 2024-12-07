package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.dtos.userdto.CreateUserDto;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRepositories;
import com.example.demo.util.GenericMapper;

@Service
public class UserService {
    private UserRepositories userRepositories;

    public UserService(UserRepositories userRepositories) {
        this.userRepositories = userRepositories;
    }

    public Long getUserId(String username) {
        User user = userRepositories.findByUsername(username);
        return user.getUserId();
    }

    public String creatUser(CreateUserDto createUserDto) {
        User user = new User();
        user = GenericMapper.map(createUserDto, User.class);
        userRepositories.save(user);
        return "User Created Successfully";
    }

    public String deleteUser(String username) {
        User user = userRepositories.findByUsername(username);
        userRepositories.delete(user);
        return "User Deleted Successfully";
    }

    public String updateUser(String username, CreateUserDto createUserDto) {
        User user = userRepositories.findByUsername(username);
        user = GenericMapper.map(createUserDto, User.class);
        userRepositories.save(user);
        return "User Updated Successfully";
    }

    public User getUser(String username) {
        return userRepositories.findByUsername(username);
    }
}
