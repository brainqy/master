package com.brainqy.master.dtos;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class UpdateQuizDetailsDto {
    @Size(max = 255)
    private String topic;
    @Size(max = 1000)
    private String description;
    // Not allowing questions to be changed here, separate endpoint for that if needed
}
