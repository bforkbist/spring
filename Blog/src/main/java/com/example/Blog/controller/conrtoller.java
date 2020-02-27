package com.example.Blog.controller;

import com.example.Blog.exception.ResourceException;
import com.example.Blog.model.Customer;
import com.example.Blog.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/add")
public class conrtoller {
    private final CustomerRepo customerRepo;

    @Autowired
    public conrtoller(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @GetMapping("/customerget")
    public String getAllCustomer(){ return "add";
    }

    @PostMapping("/customerpost")
    public String showAllCustomer(@Valid @RequestBody Customer customer){
        return "add";
    }
    @PutMapping("/customer/put/{customerId}")
    public String updateAll(@PathVariable(value = "customerId") Long customerId, @Valid @RequestBody Customer customerDetails){
        Customer customer = customerRepo.findById(customerId)
                .orElseThrow(() -> new ResourceException("Customer", "customerId", customerId));

        customer.setName(customerDetails.getName());
        customer.setAge(customerDetails.getAge());
        Customer updatedCustomer = customerRepo.save(customer);
        return "add";
    }
}
