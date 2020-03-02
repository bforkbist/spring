package com.example.employee2.service;

import com.example.employee2.model.Employee;
import com.example.employee2.repository.EmployeeRepo;
import com.example.employee2.repository.ManagerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.io.Serializable;


@Controller
@RequestMapping("/employee")
public class EmployeeService implements Serializable {

    @Autowired
    EmployeeRepo departmentRepo;

    @GetMapping("list")
    public String getDepartment(Model model){
        model.addAttribute("employee",departmentRepo.findAll());
        return "listemployee";
    }
//    @GetMapping("list/id/")
//    public String getDepartment(@PathVariable(name = "id") Long id){
//
//        return "list";
////                departmentRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee","deptId",id));
//    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Employee student = departmentRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Employee Id:" + id));
        model.addAttribute("employee", student);
        return "updateemployee";
    }

    @PostMapping("edit/")
    public String updateStudent( @Valid Employee student,
                                 Model model, BindingResult result) {
//        if (result.hasErrors()) {
//            student.setDeptId(id);
//            return "update";
//        }
        System.out.println("put");
        departmentRepo.save(student);
        model.addAttribute("employee", student);

        return "redirect:/employee/listemployee";
    }

    @GetMapping("/add")
    public String createDepartment(Employee employee){
//        if (bindingResult.hasErrors())

        return "addEmployee";
//        }
//        departmentRepo.save(employee);
//        return "add";
    }

    @PostMapping("/add")
    public String addDepartment(@Valid Employee employee, Model model ){

        model.addAttribute("employee",employee);
        departmentRepo.save(employee);

        System.out.println("hello");
        return "redirect:/employee/listemployee";
    }



    @GetMapping("delete/{id}")
    public String deleteStudent(@PathVariable("id") long id, Model model) {
        Employee student = departmentRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        departmentRepo.delete(student);
        model.addAttribute("students", departmentRepo.findAll());
        return "redirect:/employee/listemployee";
    }


}

