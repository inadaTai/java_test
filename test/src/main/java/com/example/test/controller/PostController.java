package com.example.test.controller;

import com.example.test.entity.PostEntity;
import com.example.test.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("index")
public class PostController {
    @Autowired
    PostService postService;

    @RequestMapping(method = RequestMethod.GET)
    List<postEntity> getTweet() {
        return userService.getAccount();
    }
}