package com.brainqy.master.dtos;

/**
 * Description of the class or file.
 *
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @project master
 * @since 19-05-2025
 */
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResumeScanHistoryResponseDto {
    private Long id;
    private String tenantId;
    private Long userId;
    private String resumeIdUsed; // Can be ResumeProfile.id or a temporary ID
    private String resumeNameSnapshot;
    private String jobTitleScannedFor;
    private String companyNameScannedFor;
    private String resumeTextSnapshot; // Potentially a snippet for list views
    private String jobDescriptionTextSnapshot; // Potentially a snippet
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private Date scanDate;
    private Integer matchScore;
    private boolean bookmarked;
    // private String analysisResultJson; // You might choose to expose key parts instead of raw JSON
    // For example, if you have a simplified summary DTO:
    // private SimplifiedAnalysisSummaryDto summary;
}
