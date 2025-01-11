package com.thekleinbottle.as_backend.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name="appuser")
    // private AppUser appuser;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
    private List<DmarcRecord> dmarcrecords;
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
    private List<AppUser> appusers;
    
    
    public Account() {}

    public List<DmarcRecord> getDarcRecords() {
        return dmarcrecords;
    }

    public List<AppUser> getAppUsers() {
        return appusers;
    }

}
