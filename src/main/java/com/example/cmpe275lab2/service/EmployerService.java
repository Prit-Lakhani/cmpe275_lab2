package com.example.cmpe275lab2.service;

import com.example.cmpe275lab2.entity.Employer;
import com.example.cmpe275lab2.repository.EmployerRepository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import net.minidev.json.JSONObject;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployerService {
    @Autowired
    private EmployerRepository employerRepository;
    @PersistenceContext
    private EntityManager entityManager;

    public ResponseEntity<?> createEmployer(String name, String description, String employerId) throws JSONException {
        Employer e_name = employerRepository.findByName(name);

        if(e_name != null){
            return new ResponseEntity<>(errorMessage("Bad Request", "409", "Employer with the same name is already exists."), HttpStatus.CONFLICT);
        }

        //Creating JSON Object
        JSONObject employerJSON = new JSONObject();
        System.out.println("creating employer..");
        Employer newEmployer = new Employer(name, description, employerId);
        entityManager.persist(newEmployer);

        employerJSON.put("id", newEmployer.getId());
        employerJSON.put("name", name);
        employerJSON.put("description", description);
        employerJSON.put("employerId", employerId);

        return new ResponseEntity<>(employerJSON.toString(), HttpStatus.CREATED);
    }

    public String errorMessage(String header, String code, String message){
        JSONObject result = new JSONObject();
        JSONObject error = new JSONObject();

        try{
            result.put(header, error);
            error.put("code", code);
            error.put("msg", message);
        }catch(Exception e){
            System.out.println("errorMessage() catch");
        }

        return result.toString();
    }

}
