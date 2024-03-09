package com.growSkill.Controller;

import com.growSkill.Exception.CourseException;
import com.growSkill.Model.Course;
import com.growSkill.Service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;


    // Add Course Details
    @PostMapping("/course/addCourse")
    ResponseEntity<Course> addCourseHandler(@Valid @RequestBody Course course){

        Course c=courseService.addCourse(course);

        return new ResponseEntity<>(c, HttpStatus.CREATED);
    }

    // Get all Course Details
    @GetMapping("/course/allCourse")
    ResponseEntity<List<Course>> getCourseHandler()throws CourseException{

        List<Course> c=courseService.getAllCourse();

        return new ResponseEntity<>(c,HttpStatus.OK);
    }

    // Update Course Details by id
    @PutMapping("/course/updateCourse/{id}")
    ResponseEntity<Course>  updateCourseHandler(@PathVariable Long id,@RequestBody Course course){

        Course c=courseService.updateCourse(id,course);

        return new ResponseEntity<>(c,HttpStatus.ACCEPTED);
    }

    // Delete Course Details by id
    @DeleteMapping("/course/deleteCourse/{id}")
    ResponseEntity<Course> deleteCourseHandler(@PathVariable Long id){
        Course c=courseService.deleteCourse(id);

        return new ResponseEntity<>(c,HttpStatus.OK);
    }
}
