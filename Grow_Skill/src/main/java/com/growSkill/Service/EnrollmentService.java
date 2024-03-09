package com.growSkill.Service;

import com.growSkill.Exception.ClassSessionException;
import com.growSkill.Exception.CourseException;
import com.growSkill.Exception.CustomerException;
import com.growSkill.Exception.InstructorException;
import com.growSkill.Model.ClassSession;
import com.growSkill.Model.Course;
import com.growSkill.Model.Enrollment;

import java.util.List;
import java.util.Optional;

public interface EnrollmentService {

    public Course courseEnrollClasses(Long courseId,Long classId)throws CourseException, ClassSessionException;

    public Optional<Course> assignInstructor(Long courseId,Long instId)throws CourseException, InstructorException;

    public Enrollment enrollCustomer(Long customerId, Long courseId)throws CustomerException,CourseException;



}
