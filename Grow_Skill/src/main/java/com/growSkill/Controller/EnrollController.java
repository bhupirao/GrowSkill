package com.growSkill.Controller;

import com.growSkill.Exception.ClassSessionException;
import com.growSkill.Exception.CourseException;
import com.growSkill.Exception.CustomerException;
import com.growSkill.Exception.InstructorException;
import com.growSkill.Model.Course;
import com.growSkill.Model.Enrollment;
import com.growSkill.Service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class EnrollController {

    @Autowired
    private EnrollmentService enrollmentService;


    // Here we Handle the course with class session
    @PostMapping("/course/{cId}/session/{sId}")
    ResponseEntity<Course> courseEnrollClassesHandler(@PathVariable Long cId,@PathVariable Long sId)throws CourseException, ClassSessionException{

        Course cs=enrollmentService.courseEnrollClasses(cId,sId);

        return new ResponseEntity<>(cs, HttpStatus.OK);
    }

    // Here we Handle the Course with Instructor
    @PutMapping("/course/{cId}/instructor/{instId}")
    ResponseEntity<Optional<Course>> assignInstructorHandler(@PathVariable Long cId,@PathVariable Long instId)throws CourseException, InstructorException{

        Optional<Course> cs=enrollmentService.assignInstructor(cId,instId);

        return new ResponseEntity<>(cs,HttpStatus.OK);

    }

    // Here we Handle Customer with Course
    @PostMapping("/enroll/{customerId}/{courseId}")
    public ResponseEntity<Enrollment> enrollCustomer(@PathVariable Long customerId, @PathVariable Long courseId)throws CourseException, CustomerException {

        Enrollment enrollment = enrollmentService.enrollCustomer(customerId, courseId);

        return new ResponseEntity<>(enrollment,HttpStatus.OK);

    }




}
