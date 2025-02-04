package com.thekleinbottle.as_backend.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.thekleinbottle.as_backend.domain.Account;
import com.thekleinbottle.as_backend.domain.AccountRepository;

@RestController
public class AccountController {
    @Autowired
    private final AccountRepository repository;

    public AccountController(AccountRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/account/{id}")
    public Optional<Account> getAccount(@PathVariable Long id) {
        Optional<Account> acct = repository.findById(id);
        return acct;
    } 

    @GetMapping("/accounts")
    public Iterable<Account> getAccounts() {
        return repository.findAll();
    }  

    @GetMapping("/account/{id}/appusersCount")
    public int getAppusersCount(@PathVariable Long id) {
        Optional<Account> account = repository.findById(id);
        return 3;
    }
}
