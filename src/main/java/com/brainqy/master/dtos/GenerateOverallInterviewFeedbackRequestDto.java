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
public class GenerateOverallInterviewFeedbackRequestDto {
    private String topic;
    private String jobDescription;
    private List<EvaluatedAnswerDto> evaluatedAnswers;
}