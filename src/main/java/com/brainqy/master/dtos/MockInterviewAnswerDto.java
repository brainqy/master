package com.brainqy.master.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
class MockInterviewAnswerDto {
    private String questionId;
    private String questionText;
    private String userAnswer;
    private String aiFeedback;
    private Integer aiScore;
    private List<String> strengths;
    private List<String> areasForImprovement;
    private List<String> suggestedImprovements;
}
