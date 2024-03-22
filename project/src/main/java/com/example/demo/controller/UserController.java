package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.services.*;
import com.example.demo.model.*;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userServices;

    @Autowired
    public void userController(UserService userService) {
        this.userServices = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userServices.allUsers();
    }

}
