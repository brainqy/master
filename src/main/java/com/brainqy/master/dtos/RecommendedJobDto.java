package com.brainqy.master.dtos;

/**
 * Description of the class or file.
 *
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @project master
 * @since 19-05-2025
 */
import lombok.Data;

@Data
public class RecommendedJobDto {
    private String jobId;
    private String title;
    private String company;
    private String reasoning;
    private Integer matchStrength; // 0-100
}
