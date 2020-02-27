package com.example.Blog.service;

import com.example.Blog.model.Customer;
import com.example.Blog.repo.BlogRepo;
import com.example.Blog.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    BlogRepo blogRepo;

    public List<Customer> getAllCustomer(){

        List<Customer> result = (List<Customer>) customerRepo.findAll();

        if(result.size() > 0) {
            return result;
        } else {
            return new ArrayList<Customer>();
        }

    }

//    public Customer getEmployeeById(Long id) //throws RecordNotFoundException
//    {
//        Optional<Customer> employee = customerRepo.findById(id);
//
//        if(employee.isPresent()) {
//            return employee.get();
//        } else {
//            //throw new RecordNotFoundException("No employee record exist for given id") ;
//            return employee.orElseThrow("Resourse");
//        }
//    }
//
}
