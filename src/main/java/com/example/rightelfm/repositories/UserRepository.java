package com.example.rightelfm.repositories;

import com.example.rightelfm.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    Optional<User> findUserByUserName(String username);
}
