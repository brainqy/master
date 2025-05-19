package com.brainqy.master.dtos;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * Description of the class or file.
 *
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @project master
 * @since 19-05-2025
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PracticeSessionRequestDto {
    @NotBlank(message = "Category/Type of practice is required (e.g., AI, Expert, Friend)")
    private String category; // Or an enum

    @NotBlank(message = "Practice topic is required")
    private String type; // e.g., "Java Backend", "System Design"

    @NotBlank(message = "Language is required")
    private String language;

    @NotNull(message = "Date is required")
    @FutureOrPresent
    private Date date; // Send as ISO string or timestamp

    private String notes;

    // Fields for AI session setup if this DTO is reused or specific AI DTO is used
    private Integer aiNumQuestions;
    private String aiDifficulty; // "easy", "medium", "hard"
    private Integer aiTimerPerQuestion;
    private List<String> aiQuestionCategories; // List of InterviewQuestionCategory enum strings

    // Fields for "Practice with Friends"
    private String friendEmail;
}
