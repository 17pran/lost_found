package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.User;

public interface UserRepository extends JpaRepository<User, String> {

    User findByUsernameAndPassword(String username, String password);

    User findByUsername(String username); // optional but useful
}
