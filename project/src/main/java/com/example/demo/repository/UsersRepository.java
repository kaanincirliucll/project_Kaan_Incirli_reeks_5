package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public class UsersRepository {
    private List<User> users;

    public UsersRepository() {
        users = new ArrayList<>();
        // Add some sample users for demonstration
        users.add(new User("Bella", "565", "bella@gmail.com", 18));
    }

    public List<User> allUsers() {
        return users;
    }
}
