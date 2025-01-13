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
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username, firstname, lastname;
    private boolean isAdmin;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="account")
    private Account account;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "appuser")
    private List<HelpTicket> ticket;
  
    public AppUser() {
    }

    // public AppUser(String username, String firstname, String lastname) {
    //     super();
    //     this.username = username;
    //     this.firstname = firstname;
    //     this.lastname = lastname;
    //     this.isAdmin = false;
    //     this.account = new Account();
    // }

    public AppUser(String username, String firstname, String lastname, Account account) {
        super();
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.isAdmin = false;
        this.account = account;
    }

    public Long getId() {
        return id;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
