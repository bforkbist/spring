package com.example.employee.model;

import org.hibernate.annotations.Cascade;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "emp")
@EntityListeners(AuditingEntityListener.class)
public class Emp implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;


    private Long salary;

    @NotBlank
    private String address;

    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @ManyToOne(cascade = CascadeType.ALL)
    private Long deptId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getDept_id() {
        return deptId;
    }

    public void setDept_id(Long dept_id) {
        this.deptId = dept_id;
    }

    // Getters and Setters ... (Omitted for brevity)
}