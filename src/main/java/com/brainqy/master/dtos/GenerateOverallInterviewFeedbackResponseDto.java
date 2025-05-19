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
public class GenerateOverallInterviewFeedbackResponseDto {
    private String overallSummary;
    private List<String> keyStrengths;
    private List<String> keyAreasForImprovement;
    private List<String> finalTips;
    private Integer overallScore; // 0-100
}
