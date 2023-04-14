package com.example.cmpe275lab2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String street; // e.g., 100 Main ST
    private String city;
    private String state;
    private String zip;

}
