package com.brainqy.master.dtos;

/**
 * Description of the class or file.
 *
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @project master
 * @since 19-05-2025
 */
import com.brainqy.master.entities.InterviewQuestion;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AIMockInterviewSetupDto {
    @NotBlank
    private String topic;
    private String jobDescription;
    @Min(1) @Max(50)
    private Integer numQuestions;
    private InterviewQuestion.InterviewQuestionDifficulty difficulty;
    private Integer timerPerQuestion;
    private List<InterviewQuestion.InterviewQuestionCategory> questionCategories;
}