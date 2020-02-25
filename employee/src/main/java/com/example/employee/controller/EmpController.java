package com.example.employee.controller;

import com.example.employee.exception.ResourceNotFoundException;
import com.example.employee.model.Emp;
import com.example.employee.repositroy.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("e")
public class EmpController {

    @Autowired
    EmpRepo emprepo;

    // Get All Emp
    @GetMapping("/emp")
    public List<Emp> getAllEmps() {
        return emprepo.findAll();
    }
    // Create a new Emp
    @PostMapping("/emp")
    public Emp createEmp(@Valid @RequestBody Emp emp) {
        return emprepo.save(emp);
    }
    // Get a Single Emp
    @GetMapping("/emp/{id}")
    public Emp getEmpById(@PathVariable(value = "id") Long noteId) {
        return emprepo.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Emp", "id", noteId));
    }
    // Update a Emp
    @PutMapping("/emp/{id}")
    public Emp updateEmp(@PathVariable(value = "id") Long noteId,
                           @Valid @RequestBody Emp noteDetails) {

        Emp emp = emprepo.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Emp", "id", noteId));

        emp.setName(noteDetails.getName());
        emp.setSalary(noteDetails.getSalary());
        emp.setAddress(noteDetails.getAddress());
        emp.setDept_id(noteDetails.getDept_id());


        Emp updatedEmp = emprepo.save(emp);
        return updatedEmp;
    }
    // Delete a Emp
    @DeleteMapping("/emp/{id}")
    public ResponseEntity<?> deleteEmp(@PathVariable(value = "id") Long noteId) {
        Emp emp = emprepo.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Emp", "id", noteId));

        emprepo.delete(emp);

        return ResponseEntity.ok().build();
    }
}
