package com.brainqy.master.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

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
public class SurveyResponseRequestDto {
    // surveyId will likely be a path variable
    // userId comes from authenticated principal

    @NotNull(message = "Response data is required")
    private Map<String, Object> responseData; // Key-value pairs of answers
}
