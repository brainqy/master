package com.brainqy.master.dtos;

/**
 * Description of the class or file.
 *
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @project master
 * @since 18-05-2025
 */
import com.brainqy.master.entities.JobType;
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
public class JobOpeningResponseDto {
    private Long id;
    private String tenantId;
    private String title;
    private String company;
    private String location;
    private String description; // Consider a snippet for list views
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date datePosted;
    private JobType type;
    private Long postedByUserId;
    private String postedByUserName;
    private String applicationLink;
}
