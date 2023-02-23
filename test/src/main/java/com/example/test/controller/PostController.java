package com.example.test.controller;

import com.example.test.entity.PostEntity;
import com.example.test.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("posts")
public class PostController {
    @Autowired
    PostService postService;

    @GetMapping("index")
    List<PostEntity> index() {
        return postService.getAllPost();
    }

    @GetMapping("{id}")
    PostEntity getById(@PathVariable("id") Integer id) {
        return postService.getPost(id);
    }

    @PostMapping
    public void save(@RequestMapping PostEntity postEntity) {
        postService.savePost(postEntity);
    }

    @DeleteMapping("{id}")
    public User delete(@PathVariable("id") Integer id) {
        postService.deletePost(id);
    }
}