package com.brainqy.master.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description of the class or file.
 *
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @project master
 * @since 18-05-2025
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TenantRequestDto {

    @NotBlank(message = "Tenant ID is required for updates, can be generated for creates")
    @Size(max = 50)
    private String id; // For creation, this might be auto-generated or user-provided

    @NotBlank(message = "Tenant name is required")
    @Size(max = 100)
    private String name;

    @Size(max = 100)
    private String domain;

    @org.hibernate.validator.constraints.URL(message = "Invalid logo URL")
    @Size(max = 255)
    private String customLogoUrl;

    @Pattern(regexp = "^hsl\\(\\d{1,3}\\s\\d{1,3}%\\s\\d{1,3}%\\)$|^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$", message = "Invalid HSL or HEX color format")
    @Size(max = 50)
    private String primaryColor;

    @Pattern(regexp = "^hsl\\(\\d{1,3}\\s\\d{1,3}%\\s\\d{1,3}%\\)$|^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$", message = "Invalid HSL or HEX color format")
    @Size(max = 50)
    private String accentColor;

    private Boolean allowPublicSignup;
    private Boolean communityFeedEnabled;
    private Boolean jobBoardEnabled;
    private Boolean gamificationEnabled;
    private Boolean walletEnabled;
    private Boolean eventRegistrationEnabled;
}
