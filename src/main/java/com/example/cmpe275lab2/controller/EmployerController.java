package com.example.cmpe275lab2.controller;

import com.example.cmpe275lab2.entity.Employer;
import com.example.cmpe275lab2.service.EmployerService;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Transactional
@RestController
public class EmployerController {

    @Autowired
    private EmployerService employerService;


    @RequestMapping(value="/employer", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createEmployer(
            @RequestParam("name") String name,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "employerId", required = false) String employerId
    ) throws JSONException {

        ResponseEntity<?> newEmployer = employerService.createEmployer(name, description, employerId);

        return newEmployer;
    }

}
