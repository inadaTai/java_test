package com.example.test.controller;

import com.example.test.entity.UserEntity;
import com.example.test.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("showaccount")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    List<UserEntity> getTweet() {
        return userService.getAccount();
    }
}