package com.example.test.service;

import com.example.test.entity.PostEntity;
import com.example.test.repository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PostService {
    @Autowired
    PostRepository postRepository;

    public List<PostEntity> getAllPost() {
        return postRepository.findAll();
    }

    public List<PostEntity> getPost(String id) {
        return postRepository.findById(id).orElseThrow();;
    }
}