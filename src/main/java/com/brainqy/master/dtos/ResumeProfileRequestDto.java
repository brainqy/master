package com.brainqy.master.dtos;

/**
 * Description of the class or file.
 *
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @project master
 * @since 18-05-2025
 */
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeProfileRequestDto {

    @NotBlank(message = "Resume name is required")
    @Size(max = 255, message = "Resume name cannot exceed 255 characters")
    private String name;

    @NotBlank(message = "Resume text is required")
    // @Lob // Not a JPA entity, so @Lob isn't used here, but indicates large text
    private String resumeText;
}
// File: c
