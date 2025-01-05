package com.thekleinbottle.as_backend.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long adminid;
    private String username, firstname, lastname;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "admin")
    private List<DmarcRecord> dmarcrecords;
  
    public Admin() {
    }

    public Admin(String username, String firstname, String lastname) {
        super();
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<DmarcRecord> getDmarcRecords() {
        return dmarcrecords;
    }

    public void setDmarcRecords(List<DmarcRecord> dmarcrecords) {
        this.dmarcrecords = dmarcrecords;
    }
}
