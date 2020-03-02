package com.example.employee2.repository;

import com.example.employee2.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    @Query(value = "SELECT * FROM Employee ORDER BY salary DESC",nativeQuery = true)
    List<Employee> Q1();

    @Query(value = "SELECT * FROM Employee WHERE name LIKE '%a%'",nativeQuery = true)
    List<Employee> Q2();

    @Query(value = "SELECT salary FROM Employee",nativeQuery = true)
    List<String> Q3();

    @Query(value = "SELECT * FROM Employee WHERE dept_id != 8",nativeQuery = true)
    List<Employee> Q4();

    @Query(value = "SELECT AVG(salary) FROM Employee WHERE designation = 'analyst'",nativeQuery = true)
    Long Q5();

    @Query(value = "SELECT salary FROM Employee",nativeQuery = true)
    List<Employee> Q6();

    @Query(value = "SELECT salary FROM Employee",nativeQuery = true)
    List<Employee> Q7();

    @Query(value = "SELECT salary FROM Employee",nativeQuery = true)
    List<Employee> Q8();

    @Query(value = "SELECT salary FROM Employee",nativeQuery = true)
    List<Employee> Q9();

    @Query(value = "SELECT salary FROM Employee",nativeQuery = true)
    List<Long> Q10();
}
