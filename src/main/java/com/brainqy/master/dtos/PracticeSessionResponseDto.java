package com.brainqy.master.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
public class PracticeSessionResponseDto {
    private Long id;
    private Long userId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private Date date;
    private String category;
    private String type;
    private String language;
    private String status; // From PracticeSessionStatus enum
    private String notes;
    // AI specific fields if applicable
    private Integer aiNumQuestions;
    private String aiDifficulty;
    private Integer aiTimerPerQuestion;
    private List<String> aiQuestionCategories;
}
