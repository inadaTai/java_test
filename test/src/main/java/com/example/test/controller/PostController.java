package com.example.test.controller;

import com.example.test.entity.PostEntity;
import com.example.test.service.PostService;
import com.example.test.repository.PostRepository;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("api/posts")
@CrossOrigin
public class PostController {
    
    private static final Logger log = LoggerFactory.getLogger(PostController.class.getName());

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

    @PostMapping("/create") 
    public ResponseEntity<PostEntity> createPost(PostEntity postEntity) {
        log.info("test_message");
        log.info(postEntity.toString());
        postEntity.setCreatedAt();
        PostEntity savedPost = postService.savePost(postEntity);
        return ResponseEntity.created(
                ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(savedPost.getPostId())
                        .toUri())
                        .body(savedPost);
    }

    @PostMapping("/update")  
    void update(PostEntity postEntity) {
        PostEntity targetPostEntity = postService.getPost(postEntity.getPostId());
        targetPostEntity.setTitle(postEntity.getTitle());
        targetPostEntity.setContent(postEntity.getContent());
        postRepository.save(targetPostEntity);
    }

    @DeleteMapping("{id}")
    void delete(@PathVariable("id") Integer id) {
        postService.deletePost(id);
    }
}