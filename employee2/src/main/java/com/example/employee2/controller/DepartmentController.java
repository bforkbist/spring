package com.example.employee2.controller;

import com.example.employee2.exception.ResourceNotFoundException;
import com.example.employee2.model.Department;
import com.example.employee2.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController implements Serializable {

    @Autowired
    DepartmentRepo departmentRepo;

    @GetMapping("/getdept")
    public List<Department>getDepartment(){
        return departmentRepo.findAll();
    }
    @GetMapping("/getdept/id")
    public Department getDepartment(@PathVariable(name = "id") Long id){
        return departmentRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Department","deptId",id));
    }
    @PostMapping("/post")
    public Department createDepartment(@Valid @RequestBody Department department){
        return departmentRepo.save(department);
    }
    @PutMapping("/put/id")
    public Department update(@PathVariable(name = "id") Long id,@Valid @RequestBody Department department){
        Department department1 = departmentRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Department","deptId",id));
        department1.setName(department.getName());
        Department updatedept = departmentRepo.save(department1);
        return updatedept;
    }
    @DeleteMapping("getdept/id")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id){
        Department department = departmentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Department","deptId",id));
        departmentRepo.delete(department);
        return ResponseEntity.ok().build();
    }


}
