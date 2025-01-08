package com.thekleinbottle.as_backend.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String number, location, name, make, model, cpu, vcard, serial; 

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="account")
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="appuser")
    private AppUser appuser;

    public Asset() {}

    public Asset(String number, String location, String name, String make, String model, 
            String serial, String cpu, String vcard, Account account, AppUser appuser) {
        super();
        this.number = number; 
        this.location = location;
        this.name = name;
        this.make = make;
        this.model = model;
        this.serial = serial;
        this.cpu = cpu;
        this.vcard = vcard;
        this.account = account;
        this.appuser = appuser;
    }

    public String getNumber() {
        return number;
    } 

    public String getName() {
        return name;
    } 
    
    public String getmanufacturer() {
        return make;
    } 
    
    public String getModel() {
        return model;
    } 

    public String getSerial() {
        return serial;
    }
    
    public Account getAccount() {
        return account;
    }

    public AppUser getAppUser() {
        return appuser;
    }

}
