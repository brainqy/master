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
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

@Entity
@Table(name = "interview_questions")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class InterviewQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private InterviewQuestionCategory category;

    @Lob
    @Column(nullable = false)
    private String questionText;

    @Lob
    private String answerOrTip;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "interview_question_tags", joinColumns = @JoinColumn(name = "question_id"))
    @Column(name = "tag", length = 50)
    private Set<String> tags = new HashSet<>();

    private boolean isMcq;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "interview_question_mcq_options", joinColumns = @JoinColumn(name = "question_id"))
    @OrderColumn(name = "option_index")
    @Column(name = "option_text", length = 255)
    private List<String> mcqOptions = new ArrayList<>();

    @Column(length = 255)
    private String correctAnswer;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private InterviewQuestionDifficulty difficulty;

    private Double averageRating;
    private Integer ratingsCount = 0;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @OrderBy("timestamp ASC")
    private List<InterviewQuestionComment> userComments = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by_user_id")
    private User createdBy;

    private Boolean approved = false; // Default to false, requiring admin approval

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private Date createdAt;

    @ManyToMany(mappedBy = "bookmarkedQuestions", fetch = FetchType.LAZY)
    private Set<User> bookmarkedByUsers = new HashSet<>();

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }

    public enum InterviewQuestionCategory { COMMON, BEHAVIORAL, TECHNICAL, CODING, ROLE_SPECIFIC, ANALYTICAL, HR }
    public enum InterviewQuestionDifficulty { EASY, MEDIUM, HARD }
}
