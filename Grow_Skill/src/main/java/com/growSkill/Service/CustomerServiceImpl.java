package com.growSkill.Service;

import com.growSkill.Exception.CustomerException;
import com.growSkill.Model.Customer;
import com.growSkill.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public Customer addCustomer(Customer customer) {
        Customer existingUser= customerRepo.findByMobileNo(customer.getMobileNo());



        if(existingUser != null)
            throw new CustomerException("Customer Already Registered with Mobile number");


        return customerRepo.save(customer);
    }

    @Override
    public Customer getCustomerById(Long id) throws CustomerException {
        Optional<Customer> opt=customerRepo.findById(id);
        if(opt.isPresent()){

            return opt.get();
        }
        throw new CustomerException("Customer Id not found");
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) throws CustomerException {
        Optional<Customer> opt=customerRepo.findById(id);
        if(opt.isPresent()){
           Customer customer1=opt.get();
           customer1.setName(customer.getName());
           customer1.setEmail(customer.getEmail());
           customer1.setAddress(customer.getAddress());
           customer1.setMobileNo(customer.getMobileNo());

           return customerRepo.save(customer1);
        }
        throw new CustomerException("Customer Id not found");

    }

    @Override
    public Customer deleteCustomer(Long id) throws CustomerException {
        Optional<Customer> opt=customerRepo.findById(id);
        if(opt.isPresent()){
           Customer customer=opt.get();
            customerRepo.delete(customer);

            return customer;
        }
        throw new CustomerException("Customer Id not found");
    }
}
