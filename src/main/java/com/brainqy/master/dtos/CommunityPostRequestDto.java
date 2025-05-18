package com.brainqy.master.dtos;

import com.brainqy.master.entities.CommunityPost;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

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
public class CommunityPostRequestDto {

    @NotBlank(message = "Content is required for text posts or as a question for polls/events")
    @Lob
    private String content;

    @NotNull(message = "Post type is required")
    private CommunityPost.PostType type;

    private Set<@Size(max = 50) String> tags;

    // For Polls
    private List<PollOptionDto> pollOptions; // Poll options if type is POLL

    // For Events
    @Size(max = 255)
    private String eventTitle;
    private String eventDate; // ISO String format
    @Size(max = 255)
    private String eventLocation;
    private Integer attendees;
    private Integer capacity;

    // For Requests (status and assignedTo managed by service layer usually)
}
