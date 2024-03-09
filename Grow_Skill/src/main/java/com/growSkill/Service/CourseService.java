package com.growSkill.Service;

import com.growSkill.Exception.CourseException;
import com.growSkill.Model.Course;

import java.util.List;

public interface CourseService {

    public Course addCourse(Course course);

    public List<Course> getAllCourse()throws CourseException;

    public Course updateCourse(Long id,Course course)throws CourseException;

    public Course deleteCourse(Long id)throws CourseException;

}
