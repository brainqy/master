package com.brainqy.master.dtos;

import com.brainqy.master.entities.UserRole;
import com.brainqy.master.entities.UserStatus;
import jakarta.validation.constraints.Email;
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
 * @since 20-05-2025
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateRequestDto {

    // Fields that an admin or manager might update.
    // These are typically optional in an update DTO, as not all fields
    // might be updated at once. Validation should allow nulls but
    // validate if a value is provided.

    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters if provided")
    private String name;

    @Email(message = "Invalid email format if provided")
    @Size(max = 100, message = "Email cannot exceed 100 characters if provided")
    private String email;

    // Role can only be changed by an admin, or a manager to specific sub-roles within their tenant.
    // The service layer would enforce who can change roles to what.
    private UserRole role;

    // Status can be changed by admin/manager.
    private UserStatus status;

    // Tenant ID might be updatable by a super-admin.
    // A manager typically cannot change a user's tenant.
    @Size(max = 50, message = "Tenant ID cannot exceed 50 characters if provided")
    private String tenantId;

    // You could add other fields here that an admin/manager might control, for example:
    // private Integer interviewCredits;
    // private Boolean isDistinguished; (If managed directly on user entity for some reason)

    // Password changes are usually handled via a separate, dedicated endpoint
    // and DTO (e.g., AdminResetPasswordDto) for security reasons,
    // rather than including password fields in a general update DTO.
}
