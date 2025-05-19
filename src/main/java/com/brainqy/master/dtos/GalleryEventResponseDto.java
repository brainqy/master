package com.brainqy.master.dtos;

/**
 * Description of the class or file.
 *
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @project master
 * @since 19-05-2025
 */

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GalleryEventResponseDto {
    // plus id, tenantId, createdByUserName
    @NotBlank(message = "Event title is required")
    @Size(max = 255)
    private String title;

    @NotNull(message = "Event date is required")
    private Date eventDate; // Send as ISO string or timestamp

    @NotEmpty(message = "At least one image URL is required")
    private List<@URL(message = "Invalid image URL") @Size(max=500) String> imageUrls;

    @Size(max = 1000)
    private String description;
    @Size(max = 100)
    private String location;
    private Boolean approved; // For admin/manager updates
    private Boolean isPlatformGlobal; // For admin
}
