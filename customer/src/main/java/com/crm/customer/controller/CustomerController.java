package com.crm.customer.controller;


import com.crm.customer.Repository.CustomerRepo;
import com.crm.customer.exception.ResourceNotFound;
import com.crm.customer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CustomerController implements Serializable{
    @Autowired
    CustomerRepo customerRepo;

    @GetMapping("/get")
    public List<Customer> getCustomer(){
        return customerRepo.findAll();
    }

    @GetMapping("/get/{id}")
    public Optional<Customer> getCustomerOne(@PathVariable(value = "id") long id){

        return customerRepo.findById(id);
    }

    @PostMapping("/post")
    public Customer postCustomer(@RequestBody Customer customer){
        return customerRepo.save(customer);
    }

    @PutMapping("/put/{id}/")
    public Customer putCustomer(@PathVariable(name = "id") long id,@RequestBody Customer customer) {
        Customer customer1 = customerRepo.findById(id).orElseThrow(() -> new ResourceNotFound("Customer", "name", id));
        customer1.setAddress(customer.getAddress());
        customer1.setEmail(customer.getEmail());
        customer1.setMobile(customer.getMobile());
        Customer update=customerRepo.save(customer1);
        return update;
    }
    @DeleteMapping("delete/{id}/")
    public ResponseEntity<?> delete(@PathVariable(name = "id") long id){
        Customer customer=customerRepo.findById(id).orElseThrow(() -> new ResourceNotFound("Customer", "name", id));
        customerRepo.delete(customer);
        return ResponseEntity.ok().build();
    }
}
