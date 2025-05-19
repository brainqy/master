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
public class GenerateResumeVariantRequestDto {
    private String baseResumeText;
    private String targetRole;
    private String targetIndustry;
    private List<String> skillsToHighlight;
    private String tone; // "professional", "creative", "concise", "technical"
    private String additionalInstructions;
}


