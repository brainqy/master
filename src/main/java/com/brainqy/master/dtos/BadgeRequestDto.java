package com.brainqy.master.dtos;

/**
 * Description of the class or file.
 *
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @project master
 * @since 18-05-2025
 */
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BadgeRequestDto {

    @NotBlank(message = "Badge ID is required")
    @Size(max = 50, message = "Badge ID cannot exceed 50 characters")
    private String id;

    @NotBlank(message = "Badge name is required")
    @Size(max = 100, message = "Badge name cannot exceed 100 characters")
    private String name;

    @NotBlank(message = "Description is required")
    @Size(max = 255, message = "Description cannot exceed 255 characters")
    private String description;

    @NotBlank(message = "Icon name/path is required")
    @Size(max = 50, message = "Icon cannot exceed 50 characters")
    private String icon;

    @Min(value = 0, message = "XP Reward must be non-negative")
    private Integer xpReward;

    @Size(max = 255, message = "Trigger condition cannot exceed 255 characters")
    private String triggerCondition;
}