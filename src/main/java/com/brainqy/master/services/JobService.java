package com.brainqy.master.services;

import com.brainqy.master.dtos.JobApplicationRequestDto;
import com.brainqy.master.dtos.JobApplicationResponseDto;
import com.brainqy.master.dtos.JobOpeningRequestDto;
import com.brainqy.master.dtos.JobOpeningResponseDto;
import com.brainqy.master.dtos.PersonalizedJobRecommendationsRequestDto;
import com.brainqy.master.dtos.PersonalizedJobRecommendationsResponseDto;
import com.brainqy.master.entities.JobType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Description of the class or file.
 *
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @project master
 * @since 19-05-2025
 */
public interface JobService {
    // Job Applications
    JobApplicationResponseDto createJobApplication(Long userId, JobApplicationRequestDto dto);
    List<JobApplicationResponseDto> getJobApplicationsForUser(Long userId);
    JobApplicationResponseDto updateJobApplication(Long userId, Long applicationId, JobApplicationRequestDto dto);
    void deleteJobApplication(Long userId, Long applicationId);
    JobApplicationResponseDto updateJobApplicationStatus(Long userId, Long applicationId, String newStatus);

    // Job Openings
    JobOpeningResponseDto createJobOpening(Long postingUserId, JobOpeningRequestDto dto);
    Page<JobOpeningResponseDto> getAllJobOpenings(String tenantId, String title, String company, String location, JobType type, Pageable pageable);
    JobOpeningResponseDto getJobOpeningById(Long jobId);
    JobOpeningResponseDto updateJobOpening(Long postingUserId, Long jobId, JobOpeningRequestDto dto);
    void deleteJobOpening(Long postingUserId, Long jobId);
    PersonalizedJobRecommendationsResponseDto getPersonalizedJobRecommendations(Long userId, PersonalizedJobRecommendationsRequestDto requestDto);
}
