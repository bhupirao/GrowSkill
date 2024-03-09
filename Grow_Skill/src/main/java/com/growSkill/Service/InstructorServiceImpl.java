package com.growSkill.Service;

import com.growSkill.Exception.InstructorException;
import com.growSkill.Model.Instructor;
import com.growSkill.Repository.InstructorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InstructorServiceImpl implements InstructorService{


    @Autowired
    private InstructorRepo instructorRepo;


    @Override
    public Instructor addInstructor(Instructor instructor) {
        return instructorRepo.save(instructor);
    }

    @Override
    public Instructor getInstructorById(Long id) throws InstructorException {
        Optional<Instructor> opt=instructorRepo.findById(id);
        if(opt.isPresent()){
            Instructor instructor=opt.get();

            return instructor;
        }
         throw new InstructorException("Instructor Id not found");
    }

    @Override
    public Instructor updateInstructor(Long id, Instructor instructor) throws InstructorException {
        Optional<Instructor> opt=instructorRepo.findById(id);
        if(opt.isPresent()){
            Instructor inst=opt.get();
            inst.setInstructorName(instructor.getInstructorName());
            inst.setEmail(instructor.getEmail());
            inst.setSubject(instructor.getSubject());
            instructorRepo.save(inst);
            return inst;
        }
        throw new InstructorException("Instructor Id not found");

    }

    @Override
    public Instructor deleteInstructor(Long id) throws InstructorException {
        Optional<Instructor> opt=instructorRepo.findById(id);
        if(opt.isPresent()){
            Instructor instructor=opt.get();
              instructorRepo.delete(instructor);
            return instructor;
        }
        throw new InstructorException("Instructor Id not found");
    }
}
