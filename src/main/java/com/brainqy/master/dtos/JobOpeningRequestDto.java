package com.brainqy.master.dtos;

/**
 * Description of the class or file.
 *
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @project master
 * @since 18-05-2025
 */
// Assuming enum is in entity
import com.brainqy.master.entities.JobType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.hibernate.validator.constraints.URL; // For URL validation

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobOpeningRequestDto {

    @NotBlank(message = "Job title is required")
    @Size(max = 255, message = "Title cannot exceed 255 characters")
    private String title;

    @NotBlank(message = "Company name is required")
    @Size(max = 100, message = "Company name cannot exceed 100 characters")
    private String company;

    @NotBlank(message = "Location is required")
    @Size(max = 100, message = "Location cannot exceed 100 characters")
    private String location;

    @NotBlank(message = "Description is required")
    private String description; // @Lob implied for large text

    @NotNull(message = "Job type is required")
    private JobType type;

    @URL(message = "Application link must be a valid URL")
    @Size(max = 500, message = "Application link cannot exceed 500 characters")
    private String applicationLink; // Optional based on your previous types
}

