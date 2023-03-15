package com.example.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comments")
public class CommentEntity {
    @Id
    @GeneratedValue
    private int comment_id;

    @Column(nullable = false)
    private int post_id;

    @Column(nullable = false)
    private int user_id;

    @Column(nullable = false)
    private String content;
}