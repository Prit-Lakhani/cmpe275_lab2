package com.example.cmpe275lab2.repository;

import com.example.cmpe275lab2.entity.Employer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployerRepository extends JpaRepository <Employer, Long> {
    Employer findByName(String Name);
    Employer findById(long id);
}
