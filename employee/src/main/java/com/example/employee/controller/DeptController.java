package com.example.employee.controller;

import com.example.employee.exception.ResourceNotFoundException;
import com.example.employee.model.Dept;
import com.example.employee.repositroy.DeptRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("d")
public class DeptController {
    @Autowired
    DeptRepo deptrepo;

    // Get All Dept
    @GetMapping("/dept")
    public List<Dept> getAllDepts() {
        return deptrepo.findAll();
    }
    // Create a new Dept
    @PostMapping("/dept")
    public Dept createDept(@Valid @RequestBody Dept dept) {
        return deptrepo.save(dept);
    }
    // Get a Single Dept
    @GetMapping("/dept/{id}")
    public Dept getDeptById(@PathVariable(value = "id") Long dept_id) {
        return deptrepo.findById(dept_id)
                .orElseThrow(() -> new ResourceNotFoundException("Dept", "id", dept_id));
    }
    // Update a Dept
    @PutMapping("/dept/{id}")
    public Dept updateDept(@PathVariable(value = "id") Long dept_id,
                         @Valid @RequestBody Dept deptDetails) {

        Dept dept = deptrepo.findById(dept_id)
                .orElseThrow(() -> new ResourceNotFoundException("Dept", "id", dept_id));

        dept.setName(deptDetails.getName());
//        dept.setDept_id(deptDetails.getDept_id());
        dept.setStaff(deptDetails.getStaff());

        Dept updatedDept = deptrepo.save(dept);
        return updatedDept;
    }

}
