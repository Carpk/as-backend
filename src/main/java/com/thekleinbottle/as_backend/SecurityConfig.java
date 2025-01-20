package com.thekleinbottle.as_backend;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.thekleinbottle.as_backend.service.UserDetailsServiceImpl;
import com.thekleinbottle.as_backend.AuthenticationFilter;
import com.thekleinbottle.as_backend.AuthEntryPoint;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final UserDetailsServiceImpl userDetailsService;
    private final AuthenticationFilter authenticationFilter;
    private final AuthEntryPoint authEntryPoint;

    public SecurityConfig(UserDetailsServiceImpl userDetailsService, 
            AuthenticationFilter authenticationFilter, AuthEntryPoint authEntryPoint) {
        this.userDetailsService = userDetailsService;
        this.authenticationFilter = authenticationFilter;
        this.authEntryPoint = authEntryPoint;
    }

    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticvationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf((csrf) -> csrf.disable())
        .sessionManagement(
            (sessionManagement) -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authorizeHttpRequests(
            (authorizeHttpRequests) -> authorizeHttpRequests.requestMatchers(HttpMethod.POST, "/login")
        .permitAll().anyRequest().authenticated())
        .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class)
        .exceptionHandling((exceptionHandling) -> exceptionHandling.authenticationEntryPoint(authEntryPoint));

        return http.build();
    }
}
