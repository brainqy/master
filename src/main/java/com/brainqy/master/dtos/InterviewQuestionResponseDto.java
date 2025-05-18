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
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InterviewQuestionResponseDto {
    private Long id;
    private InterviewQuestion.InterviewQuestionCategory category;
    private String questionText;
    private String answerOrTip;
    private Set<String> tags;
    private boolean isMcq;
    private List<String> mcqOptions;
    private String correctAnswer; // Might be hidden for user-facing GETs unless they answered
    private InterviewQuestion.InterviewQuestionDifficulty difficulty;
    private Double averageRating;
    private Integer ratingsCount;
    private List<InterviewQuestionCommentResponseDto> userComments; // Paginate this in real app
    private Long createdByUserId;
    private String createdByUserName;
    private Boolean approved;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private Date createdAt;
    private List<Long> bookmarkedByUserIds; // Or a boolean "isBookmarkedByCurrentUser"
}
