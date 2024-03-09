package com.growSkill.Repository;

import com.growSkill.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Long> {

    public Customer  findByMobileNo(String mobileNo);
}
