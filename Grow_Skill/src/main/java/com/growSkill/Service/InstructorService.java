package com.growSkill.Service;

import com.growSkill.Exception.InstructorException;
import com.growSkill.Model.Instructor;

public interface InstructorService {

    public Instructor addInstructor(Instructor instructor);

    public Instructor getInstructorById(Long id)throws InstructorException;

    public Instructor updateInstructor(Long id,Instructor instructor)throws InstructorException;

    public Instructor deleteInstructor(Long id)throws InstructorException;




}
