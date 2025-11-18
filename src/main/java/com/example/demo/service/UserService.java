package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // Validate user login
    public boolean validateUser(String username, String password) {
        User user = repo.findByUsername(username);
        if (user == null) return false;
        return passwordEncoder.matches(password, user.getPassword());
    }

    // Register a new user
    public void register(String username, String password) {
        if (repo.findByUsername(username) != null) {
            throw new RuntimeException("Username already exists");
        }
        String hashedPassword =
