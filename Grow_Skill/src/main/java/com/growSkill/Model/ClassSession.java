package com.growSkill.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassSession {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long classId;
    private String topic;
    private LocalDateTime localDateTime;
    private String zoomLink;
    private List<String> recording=new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

}
