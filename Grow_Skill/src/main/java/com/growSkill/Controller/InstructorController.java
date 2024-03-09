package com.growSkill.Controller;

import com.growSkill.Exception.InstructorException;
import com.growSkill.Model.Instructor;
import com.growSkill.Service.InstructorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    // Add Instructor Details
    @PostMapping("/instructor/addInstructor")
    ResponseEntity<Instructor> addInstructorHandler(@Valid @RequestBody Instructor instructor){

        Instructor inst=instructorService.addInstructor(instructor);

        return new ResponseEntity<>(inst, HttpStatus.CREATED);
    }

    // Get Instructor Details by id
    @GetMapping("/instructor/{id}")
    ResponseEntity<Instructor>  getInstructorByIdHandler(@PathVariable Long id)throws InstructorException {

        Instructor inst=instructorService.getInstructorById(id);

        return new ResponseEntity<>(inst,HttpStatus.OK);
    }


    // Update Instructor Details by id
    @PutMapping("/instructor/updateInst/{id}")
    ResponseEntity<Instructor> updateInstHandler(@PathVariable Long id,@Valid @RequestBody Instructor instructor)throws InstructorException{

        Instructor inst=instructorService.updateInstructor(id,instructor);

        return new ResponseEntity<>(inst,HttpStatus.ACCEPTED);
    }

    // Delete Instructor Details by id

    @DeleteMapping("/instructor/deleteInst/{id}")
    ResponseEntity<Instructor> deleteInstHandler(@PathVariable Long id)throws InstructorException{

        Instructor inst=instructorService.deleteInstructor(id);

        return new ResponseEntity<>(inst,HttpStatus.OK);
    }
}
