package com.brainqy.master.services;

import com.brainqy.master.dtos.AuthResponseDto;
import com.brainqy.master.dtos.LoginRequestDto;
import com.brainqy.master.dtos.UserSignupRequestDto;
import com.brainqy.master.entities.User;

/**
 * Description of the class or file.
 * 
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @since 20-05-2025
 * @project master
 */
public interface AuthService {

    /**
     * Registers a new user in the system.
     *
     * @param signUpRequestDto DTO containing user registration details.
     * @return The created User entity.
     * @throws RuntimeException if the email is already in use or tenantId is invalid.
     *                          Consider using custom exceptions like EmailAlreadyExistsException,
     *                          ResourceNotFoundException for tenant.
     */
    User registerUser(UserSignupRequestDto signUpRequestDto);

    /**
     * Authenticates an existing user and returns an authentication response containing a JWT.
     *
     * @param loginRequestDto DTO containing user login credentials (email and password).
     * @return AuthResponseDto containing the JWT and basic user details.
     * @throws RuntimeException if authentication fails (e.g., bad credentials).
     *                          Consider using custom AuthenticationFailedException.
     */
    AuthResponseDto loginUser(LoginRequestDto loginRequestDto);

    // You could add other auth-related methods here if needed, e.g.:
    // void logoutUser(String token); // For token blacklisting if implementing stateful logout
    // AuthResponseDto refreshToken(String oldToken);
}
