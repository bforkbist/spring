package com.crm.customer.controller;

import com.crm.customer.Repository.ProductRepo;
import com.crm.customer.exception.ResourceNotFound;
import com.crm.customer.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/product")
@ResponseStatus(value = HttpStatus.NOT_FOUND)

public class ProductController implements Serializable {
    @Autowired
    ProductRepo productRepo;
    @GetMapping("/get")
    public List<Product> getProduct(){
        return productRepo.findAll();
    }

    @GetMapping("/get/{id}")
    public Optional<Product> getProductOne(@PathVariable(value = "id") long id){

        return productRepo.findById(id);
    }

    @PostMapping("/post")
    public Product postProduct(@RequestBody Product product){
        return productRepo.save(product);
    }

    @PutMapping("/put/{id}/")
    public Product putProduct(@PathVariable(name = "id") long id,@RequestBody Product product) {
        Product product1 = productRepo.findById(id).orElseThrow(() -> new ResourceNotFound("Product", "name", id));
        product1.setName(product.getName());
        product1.setQuantity(product.getQuantity());
        Product update=productRepo.save(product1);
        return update;
    }
    @DeleteMapping("delete/{id}/")
    public ResponseEntity<?> delete(@PathVariable(name = "id") long id){
        Product product=productRepo.findById(id).orElseThrow(() -> new ResourceNotFound("Product", "name", id));
        productRepo.delete(product);
        return ResponseEntity.ok().build();
    }
}
