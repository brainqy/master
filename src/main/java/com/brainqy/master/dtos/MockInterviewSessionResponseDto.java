package com.brainqy.master.dtos;

/**
 * Description of the class or file.
 *
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @project master
 * @since 18-05-2025
 */
import com.brainqy.master.entities.InterviewQuestion;
import com.brainqy.master.entities.MockInterviewSession;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MockInterviewSessionResponseDto {
    private Long id;
    private Long userId;
    private String topic;
    private String description; // For quizzes
    private String jobDescriptionContext;

    // These would likely be DTOs themselves
    private List<MockInterviewQuestionDto> questions;
    private List<MockInterviewAnswerDto> answers;
    private OverallFeedbackDto overallFeedback;

    private Integer overallScore;
    private MockInterviewSession.SessionStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private Date createdAt;
    private Integer timerPerQuestion;
    private List<InterviewQuestion.InterviewQuestionCategory> questionCategories;
    private InterviewQuestion.InterviewQuestionDifficulty difficulty;

    // Quiz specific fields
    private Map<String, String> quizUserAnswers; // questionId -> userAnswer
    private Integer quizScore;
    private Double quizPercentage;
    private Integer quizTimeTakenSeconds;
    private Integer quizTotalTimeSeconds;
    private Map<String, QuizCategoryStatDto> quizCategoryStats;
    private Integer quizAnsweredCount;
    private Integer quizMarkedForReviewCount;
}

