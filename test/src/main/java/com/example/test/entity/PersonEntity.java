package com.example.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "persons")
public class PersonEntity {
    @Id
    @GeneratedValue
    private int person_id;

    @Column(nullable = false)
    private String first_name;

    @Column(nullable = false)
    private String last_name;
}