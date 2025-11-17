package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public boolean validateUser(String username, String password) {
        User u = repo.findByUsernameAndPassword(username, password);
        return u != null;
    }

    public void register(String username, String password) {
        repo.save(new User(username, password, "USER"));
    }
}
