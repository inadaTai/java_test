package com.example.test.entity;

import com.example.test.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "posts")
public class PostEntity {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private int user_id;

    @ManyToOne
    UserEntity user_entity;
}