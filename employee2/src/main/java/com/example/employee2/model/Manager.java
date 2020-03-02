package com.example.employee2.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "manager")
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ManagerId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employeeId")
//    private Long EmployeeId;
    private Employee employee;

    @NotBlank
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "deptId")
//    private Long DeptId;
    private Department department;

    public Long getManagerId() {
        return ManagerId;
    }

    public void setManagerId(Long managerId) {
        ManagerId = managerId;
    }

//    public Long getEmployeeId() {
//        return EmployeeId;
//    }
//
//    public void setEmployeeId(Long employeeId) {
//        EmployeeId = employeeId;
//    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Long getDeptId() {
//        return DeptId;
//    }
//
//    public void setDeptId(Long deptId) {
//        DeptId = deptId;
//    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
