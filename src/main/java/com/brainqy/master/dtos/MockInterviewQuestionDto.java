package com.brainqy.master.dtos;

import com.brainqy.master.entities.InterviewQuestion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
class MockInterviewQuestionDto {
    private String id; // Or Long if using generated IDs from DB
    private String questionText;
    private InterviewQuestion.InterviewQuestionCategory category;
    private InterviewQuestion.InterviewQuestionDifficulty difficulty;
}
