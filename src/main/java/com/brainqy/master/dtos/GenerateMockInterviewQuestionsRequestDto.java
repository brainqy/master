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
// Assuming InterviewQuestionCategory and Difficulty are enums or strings
// import com.resumematch.entities.InterviewQuestion.InterviewQuestionCategory;
// import com.resumematch.entities.InterviewQuestion.InterviewQuestionDifficulty;


@Data
public class GenerateMockInterviewQuestionsRequestDto {
    private String topic;
    private String jobDescription;
    private Integer numQuestions;
    private String difficulty; // "easy", "medium", "hard"
    private Integer timerPerQuestion; // seconds
    private List<String> questionCategories; // List of category strings
}
