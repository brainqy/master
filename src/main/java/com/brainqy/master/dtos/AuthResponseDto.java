package com.brainqy.master.dtos;

/**
 * Description of the class or file.
 *
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @project master
 * @since 18-05-2025
 */
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponseDto {
    private String accessToken;
    private String tokenType = "Bearer";
    private Long userId;
    private String email;
    private String name;
    private String role; // e.g., "ROLE_USER", "ROLE_ADMIN"

    public AuthResponseDto(String accessToken, Long userId, String email, String name, String role) {
        this.accessToken = accessToken;
        this.userId = userId;
        this.email = email;
        this.name = name;
        this.role = role;
    }
}
