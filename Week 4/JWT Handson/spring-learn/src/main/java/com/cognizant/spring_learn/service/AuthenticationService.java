package com.cognizant.spring_learn.service;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class AuthenticationService {

    // Secret key used to sign the JWT, should be stored securely
    private static final String SECRET_KEY = "your-256-bit-secret-key-should-be-longer"; // Ensure it is at least 256 bits

    // Generate JWT token for the authenticated user
    public String generateToken(UserDetails userDetails) {

        // Create a SecretKey using the SECRET_KEY string
        SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

        // Generate the JWT token
        return Jwts.builder()
                .setSubject(userDetails.getUsername())  // Set the username as subject
                .setIssuedAt(new Date())  // Set the current time as the issue date
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))  // Token expiration (1 hour)
                .signWith(key, SignatureAlgorithm.HS256)  // Use the key and HS256 algorithm to sign
                .compact();
    }
}
