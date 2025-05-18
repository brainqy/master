package com.brainqy.master.entities;

/**
 * Description of the class or file.
 *
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @project master
 * @since 17-05-2025
 */
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "mock_interview_sessions")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class MockInterviewSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false, length = 255)
    private String topic;
    @Lob
    private String description;
    @Lob
    private String jobDescriptionContext;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String questionsJson;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String answersJson;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String overallFeedbackJson;

    private Integer overallScore;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private SessionStatus status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private Date createdAt;

    private Integer timerPerQuestion;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "mock_session_categories", joinColumns = @JoinColumn(name = "session_id"))
    @Column(name = "category", length = 30)
    private List<InterviewQuestion.InterviewQuestionCategory> questionCategories;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private InterviewQuestion.InterviewQuestionDifficulty difficulty;

    @Lob
    private String quizUserAnswersJson;
    private Integer quizScore;
    private Double quizPercentage;
    private Integer quizTimeTakenSeconds;
    private Integer quizTotalTimeSeconds;
    @Lob
    private String quizCategoryStatsJson;
    private Integer quizAnsweredCount;
    private Integer quizMarkedForReviewCount;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }

    public enum SessionStatus { PENDING, IN_PROGRESS, COMPLETED }
}

