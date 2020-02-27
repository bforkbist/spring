package com.example.Blog.controller;


import com.example.Blog.exception.ResourceException;
import com.example.Blog.model.Blog;
import com.example.Blog.model.Customer;
import com.example.Blog.repo.BlogRepo;
import com.example.Blog.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("b")
public class BlogController {
    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    BlogRepo blogRepo;

    @GetMapping("/blog")
    public List<Blog> getAllCustomer(){ return blogRepo.findAll();
    }

    @PostMapping("/blog")
    public Blog showAllCustomer(@Valid @RequestBody Blog blog){
        return blogRepo.save(blog);
    }
    @PutMapping("/blog/{blogId}")
    public Blog updateAll(@PathVariable(value = "BlogId") Long blogId, @Valid @RequestBody Blog blogDetails){
        Blog blog = blogRepo.findById(blogId)
                .orElseThrow(() -> new ResourceException("Blog", "blogId", blogId));

        blog.setReview(blogDetails.getReview());
        Blog updatedBlog = blogRepo.save(blog);
        return updatedBlog;
    }

}
