package com.growSkill.Repository;

import com.growSkill.Model.ClassSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRepo extends JpaRepository<ClassSession,Long> {


}
