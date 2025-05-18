package com.brainqy.master.dtos;

import com.brainqy.master.entities.InterviewQuestion;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
public class MockInterviewSessionCreateRequestDto {

    @NotBlank(message = "Topic is required")
    @Size(max = 255)
    private String topic;

    @Size(max = 2000)
    private String jobDescriptionContext; // Optional

    @Min(value = 1, message = "Number of questions must be at least 1")
    @Max(value = 50, message = "Number of questions cannot exceed 50")
    private Integer numQuestions;

    private InterviewQuestion.InterviewQuestionDifficulty difficulty;
    private Integer timerPerQuestion; // seconds, 0 for no timer
    private List<InterviewQuestion.InterviewQuestionCategory> questionCategories;
}
