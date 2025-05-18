package com.brainqy.master.dtos;

import com.brainqy.master.entities.JobApplicationStatus;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Description of the class or file.
 *
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @project master
 * @since 17-05-2025
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobApplicationRequestDto {

    @NotBlank(message = "Company name is required")
    @Size(max = 100)
    private String companyName;

    @NotBlank(message = "Job title is required")
    @Size(max = 100)
    private String jobTitle;

    @NotNull(message = "Status is required")
    private JobApplicationStatus status;

    @NotBlank(message = "Date applied/saved is required")
    // Consider @Pattern if specific string format is expected, or use Date and @JsonFormat
    private String dateApplied; // e.g., "yyyy-MM-dd"

    @Size(max = 2000)
    private String notes;
    @Lob
    private String jobDescription;
    @Size(max = 100)
    private String location;
    @org.hibernate.validator.constraints.URL(message = "Invalid application URL")
    @Size(max = 255)
    private String applicationUrl;

    private Date reminderDate; // Optional, send as ISO string or timestamp
    @Size(max = 100)
    private String sourceJobOpeningId;
}
