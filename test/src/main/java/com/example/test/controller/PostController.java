package com.example.test.controller;

import com.example.test.entity.PostEntity;
import com.example.test.service.PostService;
import com.example.test.repository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;

@RestController
@RequestMapping("api/posts")
@CrossOrigin
public class PostController {
    @Autowired
    PostService postService;
    PostRepository postRepository;

    @GetMapping("index")
    List<PostEntity> index() {
        return postService.getAllPost();
    }

    @GetMapping("{id}")
    PostEntity getById(@PathVariable("id") Integer id) {
        return postService.getPost(id);
    }

    @PostMapping("/insert") 
    void insert(PostEntity postEntity) {
        postRepository.save(postEntity);
    }

    @PostMapping("/update")  
    void update(PostEntity postEntity) {
        postRepository.save(postEntity);
    }

    @DeleteMapping("{id}")
    void delete(@PathVariable("id") Integer id) {
        postService.deletePost(id);
    }
}