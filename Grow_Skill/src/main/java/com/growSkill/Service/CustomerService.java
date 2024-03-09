package com.growSkill.Service;

import com.growSkill.Exception.CustomerException;
import com.growSkill.Model.Customer;

public interface CustomerService {

    public Customer addCustomer(Customer customer);

    public Customer getCustomerById(Long id)throws CustomerException;

    public Customer updateCustomer(Long id,Customer customer)throws CustomerException;

    public Customer deleteCustomer(Long id)throws CustomerException;



}
