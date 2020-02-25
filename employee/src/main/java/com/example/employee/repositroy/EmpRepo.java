package com.example.employee.repositroy;
import com.example.employee.model.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepo  extends JpaRepository<Emp, Long> {

}