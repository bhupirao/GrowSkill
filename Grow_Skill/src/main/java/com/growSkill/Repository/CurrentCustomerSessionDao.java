package com.growSkill.Repository;

import com.growSkill.Model.CurrentCustomerSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrentCustomerSessionDao extends JpaRepository<CurrentCustomerSession,Integer> {

    public CurrentCustomerSession findByUuid(String uuid);
}
