package com.brainqy.master.dtos;

/**
 * Description of the class or file.
 *
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @project master
 * @since 19-05-2025
 */
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubmitQuizAnswersRequestDto {
    // quizId typically from path variable
    // userId from authenticated principal
    @NotNull(message = "Answers map cannot be null")
    private Map<Long, String> answers; // QuestionID -> SelectedAnswerOptionText
}
