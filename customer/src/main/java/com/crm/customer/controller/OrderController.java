package com.crm.customer.controller;


import com.crm.customer.Repository.CustomerRepo;
import com.crm.customer.Repository.OrderRepo;
import com.crm.customer.Repository.ProductRepo;
import com.crm.customer.exception.ResourceNotFound;
import com.crm.customer.model.Customer;
import com.crm.customer.model.Order;
import com.crm.customer.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@ResponseStatus(value = HttpStatus.NOT_FOUND)
@RequestMapping("/order")

public class OrderController {
    @Autowired
    OrderRepo orderRepo;
    @Autowired
    ProductRepo productRepo;
    @Autowired
    CustomerRepo customerRepo;
    @GetMapping("/get")
    public List<Order> getOrder(){
        return orderRepo.findAll();
    }

    @GetMapping("/get/{id}")
    public Optional<Order> getOrderOne(@PathVariable(value = "id") long id){

        return orderRepo.findById(id);
    }

    @PostMapping("/post")
    public Order postOrder(@RequestBody Order order){
        Optional<Product> product = productRepo.findById(1l);
        Optional<Customer> customer =  customerRepo.findById(1l);

        if(product.isPresent()){
            order.setProduct(product.get());
            order.setCustomer(customer.get());
            return orderRepo.save(order);
        }else{
            System.out.println("not found");
            return null;
        }
    }

    @PutMapping("/put/{id}/")
    public Order putOrder(@PathVariable(name = "id") long id,@RequestBody Order order) {
        Order order1 = orderRepo.findById(id).orElseThrow(() -> new ResourceNotFound("Order", "name", id));
        order1.setName(order.getName());
        Order update=orderRepo.save(order1);
        return update;
    }
    @DeleteMapping("/delete/{id}/")
    public ResponseEntity<?> delete(@PathVariable(name = "id") long id){
        Order order=orderRepo.findById(id).orElseThrow(() -> new ResourceNotFound("Order", "name", id));
        orderRepo.delete(order);
        return ResponseEntity.ok().build();
    }
}
