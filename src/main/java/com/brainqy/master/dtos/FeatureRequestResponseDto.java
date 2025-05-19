package com.brainqy.master.dtos;

/**
 * Description of the class or file.
 *
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @project master
 * @since 19-05-2025
 */

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeatureRequestResponseDto {
    //fields like id, userName, timestamp, status, upvotes.
    @Size(min = 5, max = 100)
    private String title; // Optional for update

    @Size(min = 10, max = 1000)
    private String description; // Optional for update
}