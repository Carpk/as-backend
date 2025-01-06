package com.thekleinbottle.as_backend.domain;

import java.util.List;

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
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name="appuser")
    // private AppUser appuser;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
    private List<DmarcRecord> dmarcrecords;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
    private List<AppUser> appusers;
    
    
    public Account() {}



}
