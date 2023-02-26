package com.example.test.controller;

import com.example.test.entity.UserEntity;
import com.example.test.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("index")
    List<UserEntity> index() {
        return userService.getAccount();
    }

    @GetMapping("{id}")
    UserEntity getById(@PathVariable("id") Integer id) {
        return userService.getUser(id);
    }
}