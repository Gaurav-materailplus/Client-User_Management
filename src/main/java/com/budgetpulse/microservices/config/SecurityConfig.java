package com.budgetpulse.microservices.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests()
                .anyRequest().permitAll();  // ✅ Allow all requests without authentication
        return http.build();
    }
}


//FOR TEMPORARY REMOVAL OF SECURITY FOR POST AND GET REQUESTS ON POSTMAN
