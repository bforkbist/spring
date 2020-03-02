package com.example.employee2.controller;

import com.example.employee2.exception.ResourceNotFoundException;
import com.example.employee2.model.Manager;
import com.example.employee2.repository.DepartmentRepo;
import com.example.employee2.repository.EmployeeRepo;
import com.example.employee2.repository.ManagerRepo;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("Manager")
public class ManagerController implements Serializable {

    @Autowired
    ManagerRepo managerRepo;

    @Autowired
    DepartmentRepo departmentRepo;

    @Autowired
    EmployeeRepo employeeRepo;

    @GetMapping("show")
    public List<Manager> getManager(){
        return managerRepo.findAll();
    }

    @GetMapping("show/{id}")
    public Manager getMangerbyid(@PathVariable(name = "id") Long id ){
        return managerRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Manager","managerId",id));
    }

    @PostMapping("post")
    public Manager postmanager(@Valid @RequestBody Manager manager){
        return managerRepo.save(manager);
    }

    @PutMapping("put/{id}")
    public Manager putmanager(@PathVariable(name = "id") Long id,@RequestBody Manager manager){
        Manager manager1 = managerRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Manager","managerId",id));
        manager1.setName(manager.getName());
        manager1.setDeptId(manager.getDeptId());
        manager1.setEmployeeId(manager.getEmployeeId());
        return managerRepo.save(manager1);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id){
        Manager manager1 = managerRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Manager","managerId",id));
        managerRepo.delete(manager1);
        return ResponseEntity.ok().build();
    }
}
