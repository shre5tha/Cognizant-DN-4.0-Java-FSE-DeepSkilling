package com.cognizant.spring_learn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.spring_learn.model.AuthResponse;
import com.cognizant.spring_learn.service.AuthenticationService;

@RestController
public class AuthenticationController {
	@Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/authenticate")
    public AuthResponse authenticate(@RequestParam String username, @RequestParam String password) throws Exception {
        
        // Authenticate user using the provided credentials
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );

        // Retrieve user details
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        // Generate JWT token
        String token = authenticationService.generateToken(userDetails);

        return new AuthResponse(token); // Return token in response
    }
}
