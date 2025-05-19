package com.brainqy.master.configs;

/**
 * Description of the class or file.
 *
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @project master
 * @since 19-05-2025
 */
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException; // More specific exception
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails; // Spring's UserDetails
// import com.resumematch.security.UserPrincipal; // If you have a custom UserPrincipal
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {

    private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);

    @Value("${app.jwtSecret}") // Define in application.properties or application.yml
    private String jwtSecret;

    @Value("${app.jwtExpirationInMs}") // Define in application.properties or application.yml
    private int jwtExpirationInMs;

    private Key key;

    @PostConstruct
    public void init() {
        if (jwtSecret == null || jwtSecret.isEmpty()) {
            logger.error("JWT secret key is not configured. Please set 'app.jwtSecret' in your properties.");
            throw new IllegalArgumentException("JWT secret key cannot be null or empty.");
        }
        // Ensure the secret key is strong enough for the chosen algorithm (HS512 needs at least 64 bytes)
        // For HS512, key length should be 64 bytes (512 bits).
        // If your jwtSecret string is shorter, this might lead to weak keys or errors.
        // Consider using a utility to generate a secure key if needed.
        byte[] keyBytes = jwtSecret.getBytes();
        if (keyBytes.length < 64 && SignatureAlgorithm.HS512.isHmac()) {
            logger.warn("JWT Secret for HS512 is shorter than 64 bytes. This is not recommended for production.");
        }
        this.key = Keys.hmacShaKeyFor(keyBytes);
        logger.info("JWT Token Provider initialized.");
    }

    public String generateToken(Authentication authentication) {
        // Assuming UserDetails is the principal. Adapt if using a custom UserPrincipal.
        UserDetails userPrincipal = (UserDetails) authentication.getPrincipal();
        // Example if using a custom UserPrincipal that wraps your User entity:
        // UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        // String subject = String.valueOf(userPrincipal.getId()); // Using ID as subject
        // Or keep using email/username as subject:
        String subject = userPrincipal.getUsername();


        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);

        logger.info("Generating JWT token for user: {}", subject);

        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                // You can add custom claims here if needed, e.g., roles:
                // .claim("roles", userPrincipal.getAuthorities().stream()
                //                        .map(GrantedAuthority::getAuthority)
                //                        .collect(Collectors.toList()))
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }

    // Optional: Overload to generate token directly from UserDetails if Authentication object isn't available
    public String generateToken(UserDetails userDetails) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);
        logger.info("Generating JWT token directly for user: {}", userDetails.getUsername());
        return Jwts.builder()
                .setSubject(userDetails.getUsername()) // Or user ID if preferred
                .setIssuedAt(new Date())
                .setExpiration(expiryDate
                        // .claim("roles", userDetails.getAuthorities().stream()... ) // Add claims if needed
                )
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }


    public String getUsernameFromJWT(String token) { // Or getUserIdFromJWT if using ID as subject
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

        String subject = claims.getSubject();
        logger.debug("Extracted username/subject from JWT: {}", subject);
        return subject;
    }

    public boolean validateToken(String authToken) {
        if (authToken == null || authToken.trim().isEmpty()) {
            logger.warn("JWT token is null or empty.");
            return false;
        }
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(authToken);
            logger.debug("JWT token validation successful for token: {}", authToken.substring(0, Math.min(authToken.length(), 20)) + "..."); // Log a snippet
            return true;
        } catch (SignatureException ex) {
            logger.error("Invalid JWT signature: {}", ex.getMessage());
        } catch (MalformedJwtException ex) {
            logger.error("Invalid JWT token: {}", ex.getMessage());
        } catch (ExpiredJwtException ex) {
            logger.error("Expired JWT token: {}", ex.getMessage());
        } catch (UnsupportedJwtException ex) {
            logger.error("Unsupported JWT token: {}", ex.getMessage());
        } catch (IllegalArgumentException ex) {
            logger.error("JWT claims string is empty or invalid: {}", ex.getMessage());
        }
        return false;
    }
}
