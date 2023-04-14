package com.example.cmpe275lab2.entity;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name = "EMPLOYER",
        uniqueConstraints = {
        @UniqueConstraint(
                name = "name_unique",
                columnNames = "name"
                        )
        }
)
public class Employer {

    @Id
    @GeneratedValue
    private Long id;	//primary key
    @Column(nullable = false)
    private String name;	// required and must be unique
    private String description;
    private String employerId;


    public Employer(){

    }

    public Employer(String name, String description, String employerId) {
        this.name = name;
        this.description = description;
        this.employerId = employerId;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmployerId() {
        return employerId;
    }

    public void setEmployerId(String employerId) {
        this.employerId = employerId;
    }
}
