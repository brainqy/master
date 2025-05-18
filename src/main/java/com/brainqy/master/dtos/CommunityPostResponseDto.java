package com.brainqy.master.dtos;

import com.brainqy.master.entities.CommunityPost;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
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
@Builder
public class CommunityPostResponseDto {
    private Long id;
    private String tenantId;
    private Long userId;
    private String userName;
    private String userAvatar;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private Date timestamp;
    private String content;
    private CommunityPost.PostType type;
    private Set<String> tags;

    private List<PollOptionResponseDto> pollOptions;

    private String eventTitle;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private Date eventDate;
    private String eventLocation;
    private Integer attendees;
    private Integer capacity;

    private String assignedToUserName; // Name of the user assigned to a request
    private CommunityPost.RequestStatus requestStatus;

    private CommunityPost.ModerationStatus moderationStatus;
    private int flagCount;
    private List<CommunityCommentResponseDto> comments; // Paginated ideally
}
