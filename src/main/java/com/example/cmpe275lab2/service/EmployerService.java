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

        if (e_name != null) {
            return new ResponseEntity<>(errorMessage("Bad Request", "409", "Employer with the same name is already exist."), HttpStatus.CONFLICT);
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

        return new ResponseEntity<>(employerJSON.toString(), HttpStatus.OK);
    }

    //Get an employer by ID
    public ResponseEntity<?> getEmployer(long id, String responseType) {
        Employer employer = employerRepository.findById(id);

        if (employer != null) {

            if (responseType.equals("json"))
                return new ResponseEntity<>(employerToJSONString(employer), HttpStatus.OK);
            else
                return  new ResponseEntity<>(employer,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(errorMessage("BadRequest", "404", "Sorry, the requested employer with id "
                    + id +" does not exist"), HttpStatus.NOT_FOUND);
        }

//            return new ResponseEntity<>(employerToJSONString(employer), HttpStatus.OK);
        }


    //converting employer to JSON
    private String employerToJSONString (Employer employer){
        JSONObject json = new JSONObject();
        JSONObject fields = new JSONObject();

        try {
            json.put("employer", fields);

            fields.put("id", employer.getId());
            fields.put("employerId", employer.getEmployerId());
            fields.put("name", employer.getName());
            fields.put("description", employer.getDescription());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return json.toString();
    }


        //Generating Error Message
        public String errorMessage(String header, String code, String message){
            JSONObject result = new JSONObject();
            JSONObject error = new JSONObject();

            try {
                result.put(header, error);
                error.put("code", code);
                error.put("msg", message);
            } catch (Exception e) {
                System.out.println("errorMessage() catch");
            }

            return result.toString();
        }


}
