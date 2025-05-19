package com.brainqy.master.services;

/**
 * Description of the class or file.
 *
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @project master
 * @since 18-05-2025
 */
import com.brainqy.master.configs.JwtTokenProvider;
import com.brainqy.master.dtos.AuthResponseDto;
import com.brainqy.master.dtos.LoginRequestDto;
import com.brainqy.master.dtos.UserSignupRequestDto;
import com.brainqy.master.entities.Tenant;
import com.brainqy.master.entities.User;
import com.brainqy.master.entities.UserRole;
import com.brainqy.master.entities.UserStatus;
import com.brainqy.master.repos.TenantRepository;
import com.brainqy.master.repos.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // For transactional operations

import java.util.Date;

@Service
public class AuthService {

    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TenantRepository tenantRepository; // For tenant association

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private UserDetailsService userDetailsService; // Your custom UserDetailsService

    public AuthResponseDto loginUser(LoginRequestDto loginRequest) {
        logger.debug("Authenticating user: {}", loginRequest.getEmail());
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.generateToken(authentication);

        // Fetch user details to include in response
        // UserDetails userDetails = (UserDetails) authentication.getPrincipal(); // Standard UserDetails
        // Or if using a custom UserPrincipal that wraps your User entity:
        // UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        // User user = userPrincipal.getUser();

        // Alternative: Load user entity directly after successful authentication
        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found after authentication, which should not happen."));

        logger.info("Token generated for user: {}", user.getEmail());
        return new AuthResponseDto(jwt, user.getId(), user.getEmail(), user.getName(), user.getRole().toString());
    }

    @Transactional // Make registration transactional
    public User registerUser(UserSignupRequestDto signUpRequest) {
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            logger.warn("Registration failed: Email {} is already taken.", signUpRequest.getEmail());
            throw new RuntimeException("Error: Email address already in use!");
        }

        logger.debug("Registering new user: {}", signUpRequest.getEmail());
        User user = new User();
        user.setName(signUpRequest.getName());
        user.setEmail(signUpRequest.getEmail());
        user.setPasswordHash(passwordEncoder.encode(signUpRequest.getPassword()));
        user.setRole(UserRole.USER); // Default role
        user.setStatus(UserStatus.PENDING); // Or ACTIVE if no verification needed
        user.setCreatedAt(new Date());

        // Associate with tenant if tenantId is provided
        if (signUpRequest.getTenantId() != null && !signUpRequest.getTenantId().isEmpty()) {
            Tenant tenant = tenantRepository.findById(Long.valueOf(signUpRequest.getTenantId())) // Assuming tenant ID is String
                    .orElseThrow(() -> {
                        logger.warn("Registration failed: Tenant ID {} not found.", signUpRequest.getTenantId());
                        return new RuntimeException("Error: Tenant ID not found.");
                    });
            user.setTenant(tenant);
            logger.info("Associating user {} with tenant {}", signUpRequest.getEmail(), tenant.getName());
        } else {
            // Handle default tenant logic if applicable, or leave tenant as null
            // For example, find a default public tenant:
            // Tenant publicTenant = tenantRepository.findByName("Public").orElse(null);
            // user.setTenant(publicTenant);
            logger.info("User {} registered without a specific tenant.", signUpRequest.getEmail());
        }

        User result = userRepository.save(user);
        logger.info("User {} saved to database with ID: {}", result.getEmail(), result.getId());
        return result;
    }
}
