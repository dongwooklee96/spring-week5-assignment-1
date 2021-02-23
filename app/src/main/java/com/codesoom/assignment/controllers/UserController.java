package com.codesoom.assignment.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.codesoom.assignment.application.UserService;
import com.codesoom.assignment.dto.UserRequest;
import com.codesoom.assignment.dto.UserResponse;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse create(@RequestBody @Valid UserRequest userRequest) {
        return userService.createUser(userRequest);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse update(@PathVariable Long id, @RequestBody @Valid UserRequest userRequest) {
        return userService.updateUser(id, userRequest);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}