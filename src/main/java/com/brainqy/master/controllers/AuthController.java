package com.brainqy.master.controllers;

/**
 * Description of the class or file.
 *
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @project master
 * @since 18-05-2025
 */
import com.brainqy.master.dtos.AuthResponseDto;
import com.brainqy.master.dtos.LoginRequestDto;
import com.brainqy.master.dtos.UserSignupRequestDto;
import com.brainqy.master.entities.User;
import com.brainqy.master.services.AuthService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequestDto loginRequest) {
        logger.info("Login attempt for email: {}", loginRequest.getEmail());
        try {
            AuthResponseDto authResponse = authService.loginUser(loginRequest);
            logger.info("User {} logged in successfully", loginRequest.getEmail());
            return ResponseEntity.ok(authResponse);
        } catch (Exception e) { // Catch specific authentication exceptions ideally
            logger.error("Login failed for email {}: {}", loginRequest.getEmail(), e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed: " + e.getMessage());
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserSignupRequestDto signUpRequest) {
        logger.info("Registration attempt for email: {}", signUpRequest.getEmail());
        try {
            User registeredUser = authService.registerUser(signUpRequest); // Assuming registerUser returns the User entity
            logger.info("User {} registered successfully with ID: {}", registeredUser.getEmail(), registeredUser.getId());
            // Optionally, log the user in immediately after registration
            // AuthResponseDto authResponse = authService.loginUser(new LoginRequestDto(signUpRequest.getEmail(), signUpRequest.getPassword()));
            // return ResponseEntity.status(HttpStatus.CREATED).body(authResponse);
            return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully! Please login.");
        } catch (RuntimeException e) { // Catch specific exceptions like EmailAlreadyExistsException
            logger.error("Registration failed for {}: {}", signUpRequest.getEmail(), e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}

