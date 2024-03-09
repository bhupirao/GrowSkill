package com.growSkill.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.*;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;
    private String courseName;
    private String description;
    private BigDecimal price;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private Set<ClassSession> classSessions = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    @ManyToMany(mappedBy = "courses")
    private Set<Customer> customers = new HashSet<>();
}
