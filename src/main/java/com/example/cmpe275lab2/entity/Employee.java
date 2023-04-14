package com.example.cmpe275lab2.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue
    private long id;  // part of the primary key
    private String employerId; // part of the primary key
    private String name; 	// required
    private String email;
    private String title;
//    private Address address;
//    private Employer employer;
//    private Employee Manager;
//    private List<Employee> reports; // director reports who have the current employee as their manager.
//    private List<Employee> collaborators;

}
