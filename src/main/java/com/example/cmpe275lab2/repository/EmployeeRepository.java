package com.example.cmpe275lab2.repository;

import com.example.cmpe275lab2.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository <Employee, Long> {
}
