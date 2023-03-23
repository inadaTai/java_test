package com.example.test.controller;

import com.example.test.entity.UserEntity;
import com.example.test.service.UserService;
import com.example.test.entity.UserPostEntity;
import com.example.test.service.UserPostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;

@RestController
@RequestMapping("api/users")
@CrossOrigin

public class UserController {
    @Autowired
    UserService userService;
        
    @Autowired
    UserPostService userPostService;

    @GetMapping("index")
    // @ApiOperation(value = "特になし", notes = "ユーザリストを参照します")
    List<UserEntity> index() {
        return userService.getAccount();
    }

    @GetMapping("{id}")
    UserEntity getById(@PathVariable("id") Integer id) {
        return userService.getUser(id);
    }

    @GetMapping("post")
    List<UserPostEntity> getUserPosts() {
        return userPostService.findAllUserPosts();
    }
}