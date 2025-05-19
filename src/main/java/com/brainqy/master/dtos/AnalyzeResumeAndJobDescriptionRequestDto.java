package com.brainqy.master.dtos;

/**
 * Description of the class or file.
 *
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @project master
 * @since 19-05-2025
 */
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnalyzeResumeAndJobDescriptionRequestDto {

    @NotBlank(message = "Resume text cannot be empty.")
    // Consider a @Size constraint if there's a practical limit,
    // though @Lob on the entity handles large text for the database.
    // For DTOs, @Size might be more about payload limits.
    @Size(min = 50, message = "Resume text must be at least 50 characters.") // Example minimum
    private String resumeText;

    @NotBlank(message = "Job description text cannot be empty.")
    @Size(min = 50, message = "Job description text must be at least 50 characters.") // Example minimum
    private String jobDescriptionText;

    // Optional fields you might want to pass from frontend to backend if needed
    // private String userId;
    // private String resumeIdBeingAnalyzed;
}
