package com.example.employee.model;


import net.bytebuddy.implementation.bind.annotation.Default;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "dept")
@EntityListeners(AuditingEntityListener.class)

public class Dept implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dept_id;



    @NotBlank
    private String name;

    public Set<Emp> getEmp() {
        return emp;
    }

    public void setEmp(Set<Emp> emp) {
        this.emp = emp;
    }

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "dept")
    Set<Emp> emp= new HashSet<>();



    @Column
    private Long staff;




    public Long getDept_id() {
        return dept_id;
    }

    public void setDept_id(Long dept_id) {
        this.dept_id = dept_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getStaff() {
        return staff;
    }

    public void setStaff(Long staff) {
        this.staff = staff;
    }
}

