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
 * @since 19-05-2025
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
class SearchabilityDetailsDto {
    private Boolean hasPhoneNumber;
    private Boolean hasEmail;
    private Boolean hasAddress;
    private Boolean jobTitleMatchesJD;
    private Boolean hasWorkExperienceSection;
    private Boolean hasEducationSection;
    private Boolean hasProfessionalSummary;
    private String keywordDensityFeedback;
}

