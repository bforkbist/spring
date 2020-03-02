package com.example.employee2.service;

import com.example.employee2.model.Manager;
import com.example.employee2.repository.ManagerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;


@Controller
@RequestMapping("/manager")
public class ManagerService implements Serializable {

    @Autowired
    ManagerRepo departmentRepo;

    @GetMapping("list")
    public String getDepartment(Model model){
        model.addAttribute("manager",departmentRepo.findAll());
        return "list";
    }
//    @GetMapping("list/id/")
//    public String getDepartment(@PathVariable(name = "id") Long id){
//
//        return "list";
////                departmentRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Manager","deptId",id));
//    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Manager student = departmentRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Manager Id:" + id));
        model.addAttribute("manager", student);
        return "update";
    }

    @PostMapping("edit/")
    public String updateStudent( @Valid Manager student,
                                 Model model, BindingResult result) {
//        if (result.hasErrors()) {
//            student.setDeptId(id);
//            return "update";
//        }
        System.out.println("put");
        departmentRepo.save(student);
        model.addAttribute("manager", student);

        return "redirect:/manager/list";
    }

    @GetMapping("/add")
    public String createDepartment(Manager manager){
//        if (bindingResult.hasErrors())

        return "add";
//        }
//        departmentRepo.save(manager);
//        return "add";
    }

    @PostMapping("/add")
    public String addDepartment(@Valid Manager manager, Model model ){

        model.addAttribute("manager",manager);
        departmentRepo.save(manager);

        System.out.println("hello");
        return "redirect:/manager/list";
    }



    @GetMapping("delete/{id}")
    public String deleteStudent(@PathVariable("id") long id, Model model) {
        Manager student = departmentRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        departmentRepo.delete(student);
        model.addAttribute("students", departmentRepo.findAll());
        return "redirect:/manager/list";
    }


}

