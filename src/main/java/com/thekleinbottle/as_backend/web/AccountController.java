package com.thekleinbottle.as_backend.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thekleinbottle.as_backend.domain.Account;
import com.thekleinbottle.as_backend.domain.AccountRepository;

@RestController
public class AccountController {
    private final AccountRepository repository;

    public AccountController(AccountRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/account")
    public String getAccount() {
        return new String("Your Account"); 
    }  

}
