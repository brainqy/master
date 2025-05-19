package com.brainqy.master.services;

/**
 * Description of the class or file.
 *
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @project master
 * @since 19-05-2025
 */
import com.brainqy.master.dtos.*;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface ResumeService {
    // Resume Profile CRUD
    ResumeProfileResponseDto createResumeProfile(Long userId, ResumeProfileRequestDto dto);
    List<ResumeProfileResponseDto> getUserResumeProfiles(Long userId);
    ResumeProfileResponseDto getResumeProfileById(Long userId, Long resumeId);
    ResumeProfileResponseDto updateResumeProfile(Long userId, Long resumeId, ResumeProfileRequestDto dto);
    void deleteResumeProfile(Long userId, Long resumeId);

    // AI Tool Integrations (methods would call Genkit flows via AIService)
    AnalyzeResumeAndJobDescriptionResponseDto analyzeResume(Long userId, String resumeText, String jobDescriptionText, String resumeIdUsed, String resumeNameSnapshot, String jobTitleScanned, String companyNameScanned);
    GenerateResumeVariantResponseDto generateResumeVariant(Long userId, GenerateResumeVariantRequestDto dto);
    GenerateCoverLetterResponseDto generateCoverLetter(Long userId, GenerateCoverLetterRequestDto dto);
    SuggestDynamicSkillsResponseDto suggestSkillsForUser(Long userId, SuggestDynamicSkillsRequestDto dto);

    // Resume Scan History
    Page<ResumeScanHistoryResponseDto> getScanHistory(Long userId, String filter, Pageable pageable);
    ResumeScanHistoryResponseDto getScanHistoryDetail(Long userId, Long scanId); // To regenerate report
    ResumeScanHistoryResponseDto toggleBookmarkScan(Long userId, Long scanId);
    void deleteScanHistoryItem(Long userId, Long scanId);
}
