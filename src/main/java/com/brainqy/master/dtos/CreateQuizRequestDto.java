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
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateQuizRequestDto {
    @NotBlank(message = "Quiz topic/name is required")
    @Size(max = 255)
    private String topic;

    @Size(max = 1000)
    private String description;

    @NotEmpty(message = "Quiz must have at least one question")
    private List<Long> questionIds; // List of InterviewQuestion IDs
}
