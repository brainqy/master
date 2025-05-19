package com.brainqy.master.configs;

/**
 * Description of the class or file.
 *
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @project master
 * @since 19-05-2025
 */
import com.brainqy.master.entities.User;
import com.brainqy.master.entities.UserStatus;
import com.brainqy.master.repos.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.Set;



@Service
public class CustomUserDetailsService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true) // Good practice for read operations
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        logger.debug("Attempting to load user by email: {}", email);
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> {
                    // Log the error message
                    logger.error("User not found with email: {}", email);

                    // Return a new UsernameNotFoundException
                    logger.warn("User not found with email: {}", email);
                    return new UsernameNotFoundException("User not found with email: " + email);
                });

        logger.info("User found: {} with role: {}", user.getEmail(), user.getRole().name());

        // Check if the user is active
        if (user.getStatus() != UserStatus.ACTIVE) {
            logger.warn("User is not active: {}", email);
            throw new UsernameNotFoundException("User is not active: " + email);
        }

        // If you have roles, you can convert them to GrantedAuthority
        // Here we assume user.getRole() returns a Role enum or similar

        // Create a collection of GrantedAuthority from user roles
        // Spring Security expects roles to be prefixed with "ROLE_"
        Set<GrantedAuthority> authorities = Collections.singleton(
                new SimpleGrantedAuthority("ROLE_" + user.getRole().name())
        );

        // Using Spring Security's User class. Or you can create a custom UserPrincipal
        // that wraps your User entity and implements UserDetails.
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPasswordHash(),
                user.getStatus() == UserStatus.ACTIVE, // enabled
                true, // accountNonExpired
                true, // credentialsNonExpired
                true, // accountNonLocked
                authorities
        );
    }

    // Optional: A method to load UserDetails by ID if your JWT contains user ID
    @Transactional(readOnly = true)
    public UserDetails loadUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("User not found with id : " + id)
        );
        Set<GrantedAuthority> authorities = Collections.singleton(
                new SimpleGrantedAuthority("ROLE_" + user.getRole().name())
        );
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPasswordHash(),
                user.getStatus() == UserStatus.ACTIVE,
                true, true, true,
                authorities
        );
    }
}
