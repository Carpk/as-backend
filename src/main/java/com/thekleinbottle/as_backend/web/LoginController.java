package com.thekleinbottle.as_backend.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thekleinbottle.as_backend.domain.AccountCredentials;

@RestController
public class LoginController {


    @PostMapping("/login")
    public ResponseEntity<?> getToken(@RequestBody AccountCredentials credentials) {

        return (ResponseEntity<?>) ResponseEntity.ok();

    }
}
