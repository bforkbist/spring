package com.example.employee2.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long EmployeeId;

    @NotBlank
    private String Name;

    @NotBlank
    private String Designation;

    private Long Salary;

    private Long DeptId;

//    private Long ManagerId;

    public Long getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(Long employeeId) {
        EmployeeId = employeeId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }

    public Long getDeptId() {
        return DeptId;
    }

    public void setDeptId(Long deptId) {
        DeptId = deptId;
    }

//    public long getManagerID() {
//        return ManagerId;
//    }
//
//    public void setManagerID(Long managerID) {
//        ManagerId = managerID;
//    }
    public Long getSalary() {
        return Salary;
    }

    public void setSalary(Long salary) {
        Salary = salary;
    }


}
