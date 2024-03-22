package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.repository.UsersRepository;
import com.example.demo.model.*;

@Service
public class UserService {
    private UsersRepository userRepository;

    UserService(UsersRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> allUsers() {
        return userRepository.allUsers();
    }
}