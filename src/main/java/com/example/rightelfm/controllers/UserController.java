package com.example.rightelfm.controllers;

import com.example.rightelfm.models.User;
import com.example.rightelfm.repositories.UserRepository;
import com.example.rightelfm.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable(value = "id") String userId){
        return userRepository.findById(Long.valueOf(userId));
    }
}
