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

    public PostEntity getPost(Integer id) {
        return postRepository.findById(id).orElseThrow();
    }

    public void savePost(PostEntity postEntity) {
        postRepository.save(postEntity);
    }

    public void deletePost(Integer id) {
        postRepository.deleteById(id);
    }
}