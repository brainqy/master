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
class OverallFeedbackDto {
    private String overallSummary;
    private List<String> keyStrengths;
    private List<String> keyAreasForImprovement;
    private List<String> finalTips;
    private Integer overallScore;
}
