package com.example.test.service;

import com.example.test.entity.UserEntity;
import com.example.test.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<UserEntity> getAccount() {
        return userRepository.findAll();
    }
}