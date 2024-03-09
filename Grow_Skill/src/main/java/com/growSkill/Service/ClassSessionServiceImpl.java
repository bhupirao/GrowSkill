package com.growSkill.Service;

import com.growSkill.Exception.ClassSessionException;
import com.growSkill.Model.ClassSession;
import com.growSkill.Repository.ClassRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClassSessionServiceImpl implements ClassSessionService{

    @Autowired
    private ClassRepo classRepo;

    @Override
    public ClassSession addClass(ClassSession classSession) {
        return classRepo.save(classSession);
    }

    @Override
    public ClassSession getClassSession(Long id) throws ClassSessionException {
        Optional<ClassSession> opt=classRepo.findById(id);
        if(opt.isPresent()){
            ClassSession cs=opt.get();

            return cs;
        }
        throw new ClassSessionException("ClassSession Id not found");
    }

    @Override
    public ClassSession updateClassSession(Long id, ClassSession classSession) throws ClassSessionException {
        Optional<ClassSession> opt=classRepo.findById(id);
        if(opt.isPresent()){
            ClassSession cs=opt.get();
            cs.setTopic(classSession.getTopic());
            cs.setLocalDateTime(classSession.getLocalDateTime());
            cs.setRecording(classSession.getRecording());
            cs.setZoomLink(classSession.getZoomLink());

            return classRepo.save(cs);
        }
        throw new ClassSessionException("ClassSession Id not found");
    }

    @Override
    public ClassSession deleteClassSession(Long id) throws ClassSessionException {
        Optional<ClassSession> opt=classRepo.findById(id);
        if(opt.isPresent()){
            ClassSession classSession=opt.get();
               classRepo.delete(classSession);
            return classSession;
        }
        throw new ClassSessionException("ClassSession Id not found");
    }
}
