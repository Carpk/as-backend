package com.thekleinbottle.as_backend.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable=false, updatable=false)
    private Long id;
    
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
    private List<DmarcRecord> dmarcrecords;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
    private List<AppUser> appusers;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
    private List<DmarcReport> dmarcreports;
    
    
    public Account() {}

    public Account(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @JsonIgnore
    public List<DmarcRecord> getDmarcRecords() {
        return dmarcrecords;
    }

    @JsonIgnore
    public List<AppUser> getAppUsers() {
        return appusers;
    }

    public int getDmarcRecordsCount() {
        return dmarcrecords.size();
    }

    public int getDmarcReportsCount() {
        return dmarcreports.size();
    }

    public int getAppusersCount() {
        return appusers.size();
    }

}
