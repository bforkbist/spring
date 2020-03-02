package com.example.employee2.controller;

import com.example.employee2.exception.ResourceNotFoundException;
import com.example.employee2.model.Department;
import com.example.employee2.model.Employee;
import com.example.employee2.repository.DepartmentRepo;
import com.example.employee2.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Employee")
public class EmployeeController implements Serializable {

    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    DepartmentRepo departmentRepo;

    @GetMapping("/getemp")
    public List<Employee> getAllEmployees(){
        return employeeRepo.findAll();
    }

    @PostMapping("/putemp")
    public Employee createEmployee(@Valid @RequestBody Employee employee){
//        Optional<Department> dept = departmentRepo.findById(employee.getDeptId());
//        if(dept.isPresent())
//            employee.setDeptId(dept.get().getDeptId());
//        else{
//            throw new ResourceNotFoundException("Employee","EmployeeId",employee);
//        }
//        Optional<Employee> emp = employeeRepo.findById(employee.getManagerID());
//        if(emp.isPresent())
//            employee.setManagerID(emp.get().getEmployeeId());
//        else{
//            throw new ResourceNotFoundException("Employee","EmployeeId",employee);
//        }
        return employeeRepo.save(employee);
    }
    @GetMapping("/getemp/{id}")
    public Employee getEmployee(@PathVariable(name = "id") Long id){
        return employeeRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee","EmployeeId",id));
    }

    @GetMapping("/Q1")
    private List<Employee> get(){
        return employeeRepo.Q1();
    }

    @GetMapping("/Q2")
    private List<Employee> Q2(){
        return employeeRepo.Q2();
    }

    @GetMapping("/Q3")
    private List<String> Q3(){
        return employeeRepo.Q3();
    }

    @GetMapping("/Q4")
    private List<Employee> Q4(){
        return employeeRepo.Q4();
    }
    @GetMapping("/Q5")
    private Long Q5(){
        return employeeRepo.Q5();
    }
    @GetMapping("/Q6")
    private List<Employee> Q6(){
        return employeeRepo.Q6();
    }

    @PutMapping("/putemp/{id}")
    public Employee putEmployee(@PathVariable(name = "id") Long id,@Valid @RequestBody Employee employee){
        Employee employee1 = employeeRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "employeeId", id));
        employee1.setDesignation(employee.getDesignation());
//        Optional<Employee> emp1= employeeRepo.findById(employee.getEmployeeId());
//        if(emp1.isPresent()){
//            employee1.setManagerID(employee.getManagerID());
//        }
        employee1.setName(employee.getName());
        employee1.setSalary(employee.getSalary());
        employee1.setDepartment(employee.getDepartment());
//        Optional<Department> dept = departmentRepo.findById(employee.getDeptId());
//        if(dept.isPresent()){
//            employee1.setDeptId(employee.getDeptId());
//        }
        Employee updatedEmp = employeeRepo.save(employee1);
        return updatedEmp;
    }
    @DeleteMapping("/deleteEmp/{id}")
    public ResponseEntity<?> deleteemp (@PathVariable(name = "id") Long id){
        Employee employee = employeeRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee","employeeId",id));
        employeeRepo.delete(employee);
        return ResponseEntity.ok().build();
    }


}
