package com.growSkill.Controller;

import com.growSkill.Exception.CustomerException;
import com.growSkill.Model.Customer;
import com.growSkill.Service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    // add Customer Details

    @PostMapping("/customers/addCustomer")
    ResponseEntity<Customer> addCustomerHandler(@Valid @RequestBody Customer customer){

        Customer cs=customerService.addCustomer(customer);

        return new ResponseEntity<>(cs, HttpStatus.CREATED);

    }

    // Get Customer Details By id

    @GetMapping("/customers/{id}")
    ResponseEntity<Customer> getCustomerByIdHandler(@PathVariable Long id)throws CustomerException{

        Customer cs=customerService.getCustomerById(id);

        return new ResponseEntity<>(cs,HttpStatus.OK);
    }

    // Update Customer Details By id

    @PutMapping("/customers/update/{id}")
    ResponseEntity<Customer> updateCustomerHandler(@PathVariable Long id,@Valid @RequestBody Customer customer)throws CustomerException{

        Customer cs=customerService.updateCustomer(id,customer);

        return new ResponseEntity<>(cs,HttpStatus.ACCEPTED);
    }

    // Delete Customer Details By id

    @DeleteMapping("/customers/delete/{id}")
    ResponseEntity<Customer>  deleteCustomerHandler(@PathVariable Long id)throws CustomerException{

        Customer cs=customerService.deleteCustomer(id);

        return new ResponseEntity<>(cs,HttpStatus.OK);
    }

}
