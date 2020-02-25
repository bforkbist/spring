package com.example.employee.repositroy;
import com.example.employee.model.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeptRepo  extends JpaRepository<Dept, Long> {

}