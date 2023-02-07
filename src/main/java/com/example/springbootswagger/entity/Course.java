package com.example.springbootswagger.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "course_id")
    private long courseId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

}