package com.example.test.controller;

import com.example.test.entity.PostEntity;
import com.example.test.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    PostService postService;

    //配列情報を返す
    @GetMapping("/index")
    public List<PostEntity> index() {
        return postService.getAllPost();
    }

    @GetMapping("{id}")
    public List<PostEntity> getById(@PathVariable("id") String id) {
      return postService.getAllPost(id);
    }
  

    //投稿データの保存
    // @PostMapping("/form")
    // public String create(TestForm testForm) {
    // }    
}