package com.thekleinbottle.as_backend.web;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thekleinbottle.as_backend.domain.AccountCredentials;
import com.thekleinbottle.as_backend.service.JwtService;

@RestController
public class LoginController {
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public LoginController(JwtService jwtService, AuthenticationManager authenticationManager) {
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<?> getToken(@RequestBody AccountCredentials credentials) {
        UsernamePasswordAuthenticationToken creds = new UsernamePasswordAuthenticationToken(
            credentials.username(), credentials.password());
        Authentication auth = authenticationManager.authenticate(creds);
        String jwts = jwtService.getToken(auth.getName());


        return (ResponseEntity<?>) ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION,"Bearer" + jwts)
            .header(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, "Authorization").build();

    }
}
