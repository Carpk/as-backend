package com.thekleinbottle.as_backend.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String number, name, make, model, serial; 

    public Asset() {}

    public Asset(String number, String name, String make, String model, String serial) {
        super();
        this.number = number; 
        this.name = name;
        this.make = make;
        this.model = model;
        this.serial = serial;
    }

    
}
