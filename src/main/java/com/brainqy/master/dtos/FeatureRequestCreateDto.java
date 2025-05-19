package com.brainqy.master.dtos;

import jakarta.validation.constraints.NotBlank;
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
public class FeatureRequestCreateDto {
    @NotBlank(message = "Title is required")
    @Size(min = 5, max = 100)
    private String title;

    @NotBlank(message = "Description is required")
    @Size(min = 10, max = 1000)
    private String description;
}
