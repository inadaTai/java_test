package com.example.test.service;

import com.example.test.entity.UserPostEntity;
import com.example.test.repository.UserPostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
 
@Service
@Transactional
public class UserPostService {
    @Autowired
    UserPostRepository userPostRepository;

    public List<UserPostEntity> findAllUserPosts() {
        return userPostRepository.findAll();
    }

    public List<UserPostEntity> findUserPostsByUsername(String username) {
        return userPostRepository.findByUsername(username);
    }
}