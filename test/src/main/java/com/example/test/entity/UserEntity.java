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
@Table(name = "users")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class UserEntity {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private int id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String user_name;

    @OneToMany(mappedBy="userEntity")
    private List<PostEntity> postEntity;
}