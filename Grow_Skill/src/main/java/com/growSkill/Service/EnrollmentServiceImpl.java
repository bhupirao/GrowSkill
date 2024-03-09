package com.growSkill.Service;

import com.growSkill.Exception.ClassSessionException;
import com.growSkill.Exception.CourseException;
import com.growSkill.Exception.CustomerException;
import com.growSkill.Exception.InstructorException;
import com.growSkill.Model.*;
import com.growSkill.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private ClassRepo classRepo;

    @Autowired
    private InstructorRepo instructorRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private EnrollmentRepo enrollmentRepo;

    // here we enroll course with class session
    @Override
    public Course courseEnrollClasses(Long courseId, Long classId) throws CourseException, ClassSessionException {
        Optional<Course> optionalCourse = courseRepo.findById(courseId);
        if (optionalCourse.isPresent()) {
            Course course = optionalCourse.get();
            Optional<ClassSession> optionalSession = course.getClassSessions().stream()
                    .filter(session -> session.getClassId().equals(classId))
                    .findFirst();
            if (optionalSession.isPresent()) {
                ClassSession session = optionalSession.get();
                course.getClassSessions().add(session);
                return courseRepo.save(course);
            } else {
                throw new ClassSessionException("Class Session not found");
            }
        } else
            throw new CourseException("Course Not found");
    }
  // Here we Enroll Course with Instructor
    @Override
    public Optional<Course> assignInstructor(Long courseId, Long instId) throws CourseException, InstructorException {
        Optional<Course> optionalCourse = courseRepo.findById(courseId);
        Optional<Instructor> optionalInstructor = instructorRepo.findById(instId);

        if (optionalCourse.isPresent() && optionalInstructor.isPresent()) {
            Course course = optionalCourse.get();
            Instructor instructor = optionalInstructor.get();
            course.setInstructor(instructor);
            return Optional.of(courseRepo.save(course));
        } else
            throw new InstructorException("Instructor or Course not found");

    }

    // Here we Enroll Customer with Course

    @Override
    public Enrollment enrollCustomer(Long customerId, Long courseId) throws CustomerException, CourseException {
        Optional<Customer> customerOptional = customerRepo.findById(customerId);
        Optional<Course> courseOptional = courseRepo.findById(courseId);
        if (customerOptional.isPresent() && courseOptional.isPresent()) {
            Customer customer = customerOptional.get();
            Course course = courseOptional.get();
            Enrollment enrollment = new Enrollment();
            enrollment.setCustomer(customer);
            enrollment.setCourse(course);
            // Check payment status here

            Boolean flag=enrollment.getPayment();
            if(flag){
                return enrollmentRepo.save(enrollment);
            }
            throw new CustomerException("Payment not paid");
        }
        throw new CourseException("Course Not found");
    }




}
