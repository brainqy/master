package com.brainqy.master.dtos;

import com.brainqy.master.entities.JobApplicationStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Description of the class or file.
 *
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @project master
 * @since 18-05-2025
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobApplicationResponseDto {
    private Long id;
    private String companyName;
    private String jobTitle;
    private JobApplicationStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateApplied;
    private String notes;
    private String jobDescription;
    private String location;
    private String applicationUrl;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private Date reminderDate;
    private String sourceJobOpeningId;
    private Long userId;
    private String tenantId;
}