package com.brainqy.master.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
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
 * @since 19-05-2025
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SurveyDefinitionRequestDto {
    @NotBlank(message = "Survey ID/Key is required")
    @Size(max = 100)
    private String id;

    @NotBlank(message = "Survey name is required")
    @Size(max = 255)
    private String name;

    @Size(max = 1000)
    private String description;

    private String tenantId; // Optional, for tenant-specific surveys

    @NotEmpty(message = "Survey must have at least one step")
    private String stepsJson; // JSON string of List<SurveyStep>
    // Alternatively, use a List<Map<String, Object>> for steps and handle conversion in service
}