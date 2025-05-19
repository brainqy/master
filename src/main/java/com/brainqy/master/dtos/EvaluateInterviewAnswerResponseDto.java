package com.brainqy.master.dtos;

/**
 * Description of the class or file.
 *
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @project master
 * @since 19-05-2025
 */
import lombok.Data;
import java.util.List;

@Data
public class EvaluateInterviewAnswerResponseDto {
    private String feedback;
    private List<String> strengths;
    private List<String> areasForImprovement;
    private Integer score; // 0-100
    private List<String> suggestedImprovements;
}