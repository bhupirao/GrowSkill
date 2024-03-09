package com.growSkill.Service;

import com.growSkill.Exception.CourseException;
import com.growSkill.Model.Course;
import com.growSkill.Repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseRepo courseRepo;


    @Override
    public Course addCourse(Course course) {
        return courseRepo.save(course);
    }

    @Override
    public List<Course> getAllCourse() throws CourseException {

        return courseRepo.findAll();
    }

    @Override
    public Course updateCourse(Long id, Course course) throws CourseException {
        Optional<Course> opt=courseRepo.findById(id);

        if(opt.isPresent()){
            Course course1=opt.get();
            course1.setCourseName(course.getCourseName());
            course1.setDescription(course.getDescription());
            course1.setPrice(course.getPrice());

            return courseRepo.save(course1);
        }
        throw new CourseException("Course Id not found!");
    }

    @Override
    public Course deleteCourse(Long id) throws CourseException {
        Optional<Course> opt=courseRepo.findById(id);
        if(opt.isPresent()){
            Course course=opt.get();
            courseRepo.delete(course);

            return course;
        }
        throw new CourseException("Course Id not found!");
    }
}
