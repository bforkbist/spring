package com.example.Blog.controller;
import com.example.Blog.exception.ResourceException;
import com.example.Blog.model.Customer;
import com.example.Blog.repo.BlogRepo;
import com.example.Blog.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("c")
public class CustomerController {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    BlogRepo blogRepo;

    @GetMapping("/customer")
    public List<Customer> getAllCustomer(){ return customerRepo.findAll();
    }

    @PostMapping("/customer")
    public Customer showAllCustomer(@Valid @RequestBody Customer customer){
        return customerRepo.save(customer);
    }
    @PutMapping("/customer/{customerId}")
    public Customer updateAll(@PathVariable(value = "customerId") Long customerId, @Valid @RequestBody Customer customerDetails){
        Customer customer = customerRepo.findById(customerId)
                .orElseThrow(() -> new ResourceException("Customer", "customerId", customerId));

        customer.setName(customerDetails.getName());
        customer.setAge(customerDetails.getAge());
        Customer updatedCustomer = customerRepo.save(customer);
        return updatedCustomer;
    }
}
