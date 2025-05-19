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
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnalyzeResumeAndJobDescriptionResponseDto {
    private Integer hardSkillsScore;
    private List<String> matchingSkills;
    private List<String> missingSkills;
    private String resumeKeyStrengths;
    private String jobDescriptionKeyRequirements;
    private Integer overallQualityScore;
    private List<RecruiterTipItemDto> recruiterTips;
    private String overallFeedback;

    private Integer searchabilityScore;
    private Integer recruiterTipsScore;
    private Integer formattingScore;
    private Integer highlightsScore;
    private Integer softSkillsScore;
    private List<String> identifiedSoftSkills;

    private SearchabilityDetailsDto searchabilityDetails;
    private List<AtsFormattingIssueDto> formattingDetails; // General formatting

    private AtsParsingConfidenceDto atsParsingConfidence;
    private Integer atsStandardFormattingComplianceScore;
    private List<AtsFormattingIssueDto> standardFormattingIssues; // ATS-specific formatting
    private List<String> undefinedAcronyms;

    private QuantifiableAchievementDetailsDto quantifiableAchievementDetails;
    private ActionVerbDetailsDto actionVerbDetails;
    private ImpactStatementDetailsDto impactStatementDetails;
    private ReadabilityDetailsDto readabilityDetails;
}
