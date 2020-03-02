package com.example.employee2.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "manager")
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ManagerId;

    private Long EmployeeId;


    @NotBlank
    private String name;


    private Long DeptId;

    public Long getManagerId() {
        return ManagerId;
    }

    public void setManagerId(Long managerId) {
        ManagerId = managerId;
    }

    public Long getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(Long employeeId) {
        EmployeeId = employeeId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDeptId() {
        return DeptId;
    }

    public void setDeptId(Long deptId) {
        DeptId = deptId;
    }


}
