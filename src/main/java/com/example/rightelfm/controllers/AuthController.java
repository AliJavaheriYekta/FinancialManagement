package com.example.rightelfm.controllers;

import com.example.rightelfm.models.User;
import com.example.rightelfm.models.requests.AuthenticationRequest;
import com.example.rightelfm.models.requests.AuthenticationResponse;
import com.example.rightelfm.security.JwtUtil;
import com.example.rightelfm.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "GET, POST, PUT, DELETE, OPTIONS", maxAge = 3600)
@RestController
public class AuthController {

    @Autowired
    private UserService userService;

//    @Autowired
//    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    public AuthenticationResponse createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails.getUsername(), false);

        return new AuthenticationResponse(jwt);
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody AuthenticationRequest authenticationRequest) {
        User newUser = new User();
        newUser.setEmail(authenticationRequest.getEmail());
        newUser.setPassword(authenticationRequest.getPassword());
        newUser.setUserName(authenticationRequest.getUsername());
        userService.save(newUser);
        return "User registered successfully";
    }
}

