package com.brainqy.master.servicesImpl;

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
/**
 * Description of the class or file.
 *
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @project master
 * @since 20-05-2025
 */
import com.brainqy.master.services.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class AuthServiceImpl  implements AuthService {

    private static final Logger logger =  LoggerFactory.getLogger(AuthServiceImpl.class);

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final TenantRepository tenantRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider tokenProvider;

    @Autowired
    public AuthServiceImpl(AuthenticationManager authenticationManager,
                           UserRepository userRepository,
                           TenantRepository tenantRepository,
                           PasswordEncoder passwordEncoder,
                           JwtTokenProvider tokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.tenantRepository = tenantRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenProvider = tokenProvider;
    }

    @Override
    public AuthResponseDto loginUser(LoginRequestDto loginRequest) {
        logger.info("Attempting login for email: {}", loginRequest.getEmail());
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );
        logger.debug("Authentication successful for: {}", loginRequest.getEmail());

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.generateToken(authentication);

        // Fetch user details to include in response
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User user = userRepository.findByEmail(userDetails.getUsername())
                .orElseThrow(() -> {
                    // This should not happen if authentication was successful
                    logger.error("User {} authenticated but not found in DB.", userDetails.getUsername());
                    return new RuntimeException("Authenticated user not found in database.");
                });

        logger.info("JWT token generated for user: {}", user.getEmail());
        return new AuthResponseDto(
                jwt,
                user.getId(),
                user.getEmail(),
                user.getName(),
                user.getRole().name() // Assuming getRole() returns the enum
        );
    }

    @Override
    @Transactional // Ensures the whole operation is a single transaction
    public User registerUser(UserSignupRequestDto signUpRequestDto) {
        logger.info("Attempting registration for email: {}", signUpRequestDto.getEmail());

        if (userRepository.existsByEmail(signUpRequestDto.getEmail())) {
            logger.warn("Registration failed: Email {} is already taken.", signUpRequestDto.getEmail());
            throw new RuntimeException("Error: Email address '" + signUpRequestDto.getEmail() + "' is already in use!"); // Replace with custom EmailAlreadyExistsException
        }

        User user = new User();
        user.setName(signUpRequestDto.getName());
        user.setEmail(signUpRequestDto.getEmail());
        user.setPasswordHash(passwordEncoder.encode(signUpRequestDto.getPassword()));
        user.setRole(UserRole.USER); // Default role, adjust if needed
        user.setStatus(UserStatus.ACTIVE); // Or PENDING if email verification is needed
        user.setCreatedAt(new Date()); // Handled by @PrePersist if User entity has it
        user.setReferralCode(generateReferralCode()); // Implement this utility method

        if (signUpRequestDto.getTenantId() != null && !signUpRequestDto.getTenantId().isEmpty()) {
            logger.debug("Looking up tenant with ID: {}", signUpRequestDto.getTenantId());
            Tenant tenant = tenantRepository.findById(Long.valueOf(signUpRequestDto.getTenantId()))
                    .orElseThrow(() -> {
                        logger.warn("Registration failed: Tenant ID {} not found during user registration.", signUpRequestDto.getTenantId());
                        return new RuntimeException("Error: Specified Tenant ID not found."); // Replace with custom ResourceNotFoundException
                    });
            user.setTenant(tenant);
            logger.info("User {} will be associated with tenant: {}", signUpRequestDto.getEmail(), tenant.getName());
        } else {
            // Handle cases where no tenantId is provided.
            // Assign to a tenant named "Brainqy" if it's the default.
            Tenant defaultTenant = tenantRepository.findByName("Brainqy")
                    .orElseGet(() -> {
                        logger.info("Default tenant 'Brainqy' not found, creating it for user {}.", signUpRequestDto.getEmail());
                        Tenant newDefaultTenant = new Tenant();
                        newDefaultTenant.setName("Brainqy");
                        newDefaultTenant.setDomain("brainqy.com"); // Set a default domain or other properties as needed
                        newDefaultTenant.setCreatedAt(new Date());
                        // Set other default tenant properties if needed
                        return tenantRepository.save(newDefaultTenant);
                    });
            user.setTenant(defaultTenant);
            logger.info("User {} associated with default tenant: {}", signUpRequestDto.getEmail(), defaultTenant.getName());
        }

        // Initialize other user fields if needed (XP, Wallet, etc.)
        user.setXpPoints(0);
        user.setDailyStreak(0);
        // ...

        User savedUser = userRepository.save(user);
        logger.info("User {} registered successfully with ID: {}", savedUser.getEmail(), savedUser.getId());
        return savedUser;
    }

    private String generateReferralCode() {
        // Simple referral code generation logic (ensure uniqueness in a real system)
        return "REF" + (System.currentTimeMillis() % 100000);
    }
}

