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
import java.util.List;

@Data
public class PersonalizedJobRecommendationsRequestDto {
    private String userProfileText;
    private String careerInterests;
    private List<JobOpeningDetailsDto> availableJobs;
}