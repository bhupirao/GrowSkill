package com.growSkill.Service;

import com.growSkill.Exception.ClassSessionException;
import com.growSkill.Model.ClassSession;

public interface ClassSessionService {

    public ClassSession addClass(ClassSession classSession);

    public ClassSession getClassSession(Long id)throws ClassSessionException;

    public ClassSession updateClassSession(Long id,ClassSession classSession)throws ClassSessionException;

    public ClassSession deleteClassSession(Long id)throws ClassSessionException;

}
