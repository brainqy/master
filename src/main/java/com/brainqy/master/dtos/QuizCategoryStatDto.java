package com.brainqy.master.dtos;

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
class QuizCategoryStatDto {
    private int correct;
    private int total;
    private double accuracy;
}