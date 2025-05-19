package com.brainqy.master.dtos;

/**
 * Description of the class or file.
 *
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @project master
 * @since 19-05-2025
 */
import com.brainqy.master.entities.Announcement;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnnouncementRequestDto {
    @NotBlank(message = "Title is required")
    @Size(max = 255)
    private String title;

    @NotBlank(message = "Content is required")
    private String content;

    @NotNull(message = "Start date is required")
    private Date startDate;
    private Date endDate; // Optional

    @NotNull(message = "Audience is required")
    private Announcement.AnnouncementAudience audience;
    @Size(max = 50)
    private String audienceTarget; // Required if audience is SPECIFIC_TENANT or SPECIFIC_ROLE

    @NotNull(message = "Status is required")
    private Announcement.AnnouncementStatus status;
}
