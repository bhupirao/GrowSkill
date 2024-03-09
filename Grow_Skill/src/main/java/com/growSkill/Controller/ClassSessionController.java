package com.growSkill.Controller;

import com.growSkill.Exception.ClassSessionException;
import com.growSkill.Model.ClassSession;
import com.growSkill.Service.ClassSessionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClassSessionController {

    @Autowired
    private ClassSessionService sessionService;


    // Add Class Session Details

    @PostMapping("/classSession/addClass")
    ResponseEntity<ClassSession> addClassHandler(@Valid @RequestBody ClassSession classSession){

        ClassSession cs=sessionService.addClass(classSession);

        return new ResponseEntity<>(cs, HttpStatus.CREATED);
    }

    // Get Class Session Details by id

    @GetMapping("/classSession/{id}")
    ResponseEntity<ClassSession> getClassSessionByIdHandler(@PathVariable Long id)throws ClassSessionException{

        ClassSession cs=sessionService.getClassSession(id);

        return new ResponseEntity<>(cs,HttpStatus.OK);
    }

    // Update Class Session by id

    @PutMapping("/classSession/updateClass/{id}")
    ResponseEntity<ClassSession> updateClassHandler(@PathVariable Long id,@Valid @RequestBody ClassSession classSession)throws ClassSessionException{

        ClassSession cs=sessionService.updateClassSession(id,classSession);

        return new ResponseEntity<>(cs,HttpStatus.OK);
    }

    // Delete Class Session by id
    @DeleteMapping("/classSession/deleteClass/{id}")
    ResponseEntity<ClassSession> deleteClassHandler(@PathVariable Long id)throws ClassSessionException{

        ClassSession cs=sessionService.deleteClassSession(id);

        return new ResponseEntity<>(cs,HttpStatus.ACCEPTED);
    }

}
