package com.growSkill.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalException {

    //to handle any exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<MyErrorDetails> anyExpHandler(Exception ie , WebRequest rq){


        MyErrorDetails err=new MyErrorDetails();
        err.setTimestamp(LocalDateTime.now());
        err.setMessage(ie.getMessage());
        err.setDetails(rq.getDescription(false));

        return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);

    }


    public ResponseEntity<MyErrorDetails> mynotFoundHandler(NoHandlerFoundException nfe, WebRequest rq){

        MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(),nfe.getMessage(),rq.getDescription(false));
        err.setTimestamp(LocalDateTime.now());
        err.setMessage(nfe.getMessage());
        err.setDetails(rq.getDescription(false));

        return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);


    }

    //validation exception handler
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MyErrorDetails> MyInvalidDataExceptionHandler(MethodArgumentNotValidException me) {
        MyErrorDetails err=new MyErrorDetails();


        err.setTimestamp(LocalDateTime.now());
        err.setMessage("Validation error");
        err.setDetails(me.getBindingResult().getFieldError().getDefaultMessage());

        return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);


    }
  // Class Session Exception handler
    @ExceptionHandler(ClassSessionException.class)
    public ResponseEntity<MyErrorDetails> myClassSessionExpHandler(ClassSessionException ie , WebRequest rq){

        MyErrorDetails err=new MyErrorDetails();
        err.setTimestamp(LocalDateTime.now());
        err.setMessage(ie.getMessage());
        err.setDetails(rq.getDescription(false));

        return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);

    }
    // Course Exception handler
    @ExceptionHandler(CourseException.class)
    public ResponseEntity<MyErrorDetails> myCourseExpHandler(CourseException ie , WebRequest rq){

        MyErrorDetails err=new MyErrorDetails();
        err.setTimestamp(LocalDateTime.now());
        err.setMessage(ie.getMessage());
        err.setDetails(rq.getDescription(false));

        return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);

    }

    // Customer Exception handler
    @ExceptionHandler(CustomerException.class)
    public ResponseEntity<MyErrorDetails> myCustomerExpHandler(CustomerException ie , WebRequest rq){

        MyErrorDetails err=new MyErrorDetails();
        err.setTimestamp(LocalDateTime.now());
        err.setMessage(ie.getMessage());
        err.setDetails(rq.getDescription(false));

        return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);

    }

    // Enrollment Exception handler
    @ExceptionHandler(EnrollmentException.class)
    public ResponseEntity<MyErrorDetails> myEnrollExpHandler(EnrollmentException ie , WebRequest rq){

        MyErrorDetails err=new MyErrorDetails();
        err.setTimestamp(LocalDateTime.now());
        err.setMessage(ie.getMessage());
        err.setDetails(rq.getDescription(false));

        return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);

    }

    // Instructor Exception handler
    @ExceptionHandler(InstructorException.class)
    public ResponseEntity<MyErrorDetails> myInstructorExpHandler(InstructorException ie , WebRequest rq){

        MyErrorDetails err=new MyErrorDetails();
        err.setTimestamp(LocalDateTime.now());
        err.setMessage(ie.getMessage());
        err.setDetails(rq.getDescription(false));

        return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);

    }
    // Login Exception handler
    @ExceptionHandler(LoginException.class)
    public ResponseEntity<MyErrorDetails> myLoginExpHandler(LoginException ie , WebRequest rq){

        MyErrorDetails err=new MyErrorDetails();
        err.setTimestamp(LocalDateTime.now());
        err.setMessage(ie.getMessage());
        err.setDetails(rq.getDescription(false));

        return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);

    }
}
