package com.example.employee2.controller;

import com.example.employee2.exception.ResourceNotFoundException;
import com.example.employee2.model.Department;
import com.example.employee2.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartmentService implements Serializable {

    @Autowired
    DepartmentRepo departmentRepo;

    @GetMapping("list")
    public String getDepartment(Model model){
        model.addAttribute("department",departmentRepo.findAll());
        return "list";
    }
//    @GetMapping("list/id/")
//    public String getDepartment(@PathVariable(name = "id") Long id){
//
//        return "list";
////                departmentRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Department","deptId",id));
//    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Department student = departmentRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        model.addAttribute("department", student);
        return "update";
    }

    @PostMapping("edit/")
    public String updateStudent( @Valid Department student,
                                Model model, BindingResult result) {
//        if (result.hasErrors()) {
//            student.setDeptId(id);
//            return "update";
//        }
        System.out.println("put");
        departmentRepo.save(student);
        model.addAttribute("department", student);

        return "redirect:/department/list";
    }

    @GetMapping("/add")
    public String createDepartment(Department department){
//        if (bindingResult.hasErrors())

            return "add";
//        }
//        departmentRepo.save(department);
//        return "add";
    }

    @PostMapping("/add")
    public String addDepartment(@Valid Department department, Model model ){

        model.addAttribute("department",department);
        departmentRepo.save(department);

        System.out.println("hello");
        return "redirect:/department/list";
    }



    @GetMapping("delete/{id}")
    public String deleteStudent(@PathVariable("id") long id, Model model) {
        Department student = departmentRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        departmentRepo.delete(student);
        model.addAttribute("students", departmentRepo.findAll());
        return "redirect:/department/list";
    }


}

