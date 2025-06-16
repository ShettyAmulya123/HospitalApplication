package com.app.hospital.controller;

import com.app.hospital.DTO.JwtResponse;
import com.app.hospital.DTO.LoginRequest;
import com.app.hospital.DTO.SignupRequest;
import com.app.hospital.Service.UserDetailsServiceImpl;
import com.app.hospital.Service.UserService;
import com.app.hospital.config.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signupRequest) {
        userService.register(signupRequest);
        return ResponseEntity.ok("User registered successfully!");
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());
        String token = jwtUtils.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }
}
