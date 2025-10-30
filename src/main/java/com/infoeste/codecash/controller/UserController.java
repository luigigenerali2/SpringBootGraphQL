package com.infoeste.codecash.controller;

import com.infoeste.codecash.dto.CreateUserInput;
import com.infoeste.codecash.model.User;
import com.infoeste.codecash.service.UserService;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @MutationMapping
    public User createUser(CreateUserInput createUserInput) {
        return userService.createUser(createUserInput);
    }

    @QueryMapping
    public List<User> AllUsers() {
        return userService.getAllUsers();
    }
}
