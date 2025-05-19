package com.brainqy.master.services;

/**
 * Description of the class or file.
 *
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @project master
 * @since 19-05-2025
 */
import com.brainqy.master.dtos.*;
import com.brainqy.master.entities.InterviewQuestion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface InterviewPrepService {
    // Question Bank
    InterviewQuestionResponseDto createInterviewQuestion(Long userId, InterviewQuestionRequestDto dto);
    Page<InterviewQuestionResponseDto> getInterviewQuestions(List<InterviewQuestion.InterviewQuestionCategory> categories, String searchTerm, String sortOrder, String filterView, Long currentUserId, Pageable pageable);
    InterviewQuestionResponseDto getInterviewQuestionById(Long questionId);
    InterviewQuestionResponseDto updateInterviewQuestion(Long userId, Long questionId, InterviewQuestionRequestDto dto); // Admin or creator
    void deleteInterviewQuestion(Long userId, Long questionId); // Admin or creator
    InterviewQuestionCommentResponseDto addCommentToQuestion(Long userId, Long questionId, CommentRequestDto dto);
    InterviewQuestionResponseDto rateQuestion(Long userId, Long questionId, int rating);
    InterviewQuestionResponseDto toggleBookmarkQuestion(Long userId, Long questionId);
    InterviewQuestionResponseDto approveQuestion(Long adminUserId, Long questionId); // Admin only

    // Quizzes (MockInterviewSession can represent quizzes)
    MockInterviewSessionResponseDto createQuiz(Long userId, CreateQuizRequestDto dto);
    MockInterviewSessionResponseDto getQuizForTaking(Long quizId); // Gets questions for the quiz player
    MockInterviewSessionResponseDto submitQuizAnswers(Long userId, Long quizId, SubmitQuizAnswersRequestDto dto); // Calculates score, results
    List<MockInterviewSessionResponseDto> getUserQuizzes(Long userId); // Lists quizzes created by or taken by user
    MockInterviewSessionResponseDto updateQuizDetails(Long userId, Long quizId, UpdateQuizDetailsDto dto); // Edit topic, description
    void deleteQuiz(Long userId, Long quizId);

    // Practice Sessions (non-AI, expert/friend based)
    PracticeSessionResponseDto schedulePracticeSession(Long userId, PracticeSessionRequestDto dto);
    List<PracticeSessionResponseDto> getUserPracticeSessions(Long userId);
    PracticeSessionResponseDto updatePracticeSessionStatus(Long userId, Long sessionId, String status); // Cancel, complete
    PracticeSessionResponseDto reschedulePracticeSession(Long userId, Long sessionId, PracticeSessionRescheduleDto dto);

    // AI Mock Interview Sessions (uses AIService for generation/evaluation)
    // Methods here might mostly orchestrate calls to AIService and save session state
    MockInterviewSessionResponseDto startAIMockInterview(Long userId, AIMockInterviewSetupDto setupDto);
    MockInterviewSessionResponseDto submitAIMockAnswer(Long userId, Long sessionId, String questionId, String answer);
    MockInterviewSessionResponseDto completeAIMockInterview(Long userId, Long sessionId);
    List<MockInterviewSessionResponseDto> getAIMockInterviewHistory(Long userId);
}
