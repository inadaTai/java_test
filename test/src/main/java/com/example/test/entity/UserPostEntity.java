package com.example.test.entity;

import com.example.test.entity.PostEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_posts")
public class UserPostEntity {
    @Id
    private Long id;
    private String username;
    private String email;
    private String title;
    private String content;

}
