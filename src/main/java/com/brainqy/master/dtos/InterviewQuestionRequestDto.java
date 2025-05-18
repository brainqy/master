package com.brainqy.master.dtos;

/**
 * Description of the class or file.
 *
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @project master
 * @since 18-05-2025
 */
// For enums
import com.brainqy.master.entities.InterviewQuestion;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InterviewQuestionRequestDto {

    @NotNull(message = "Category is required")
    private InterviewQuestion.InterviewQuestionCategory category;

    @NotBlank(message = "Question text is required")
    private String questionText; // @Lob implied

    @NotBlank(message = "Answer or tip is required")
    private String answerOrTip; // @Lob implied

    private Set<@Size(max = 50) String> tags;
    private boolean isMcq;
    private List<@NotBlank @Size(max = 255) String> mcqOptions; // Validate if isMcq = true
    @Size(max = 255)
    private String correctAnswer; // Validate if isMcq = true and present in mcqOptions

    private InterviewQuestion.InterviewQuestionDifficulty difficulty;
    private Boolean approved; // For admin updates
}
