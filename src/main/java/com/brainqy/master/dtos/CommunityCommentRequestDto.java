package com.brainqy.master.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description of the class or file.
 *
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @project master
 * @since 19-05-2025
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommunityCommentRequestDto {

    // The postId would typically be a path variable in the controller endpoint,
    // e.g., @PostMapping("/feed/{postId}/comments")
    // So, it's not usually part of the request body DTO itself.

    // The userId would come from the authenticated principal (SecurityContextHolder)
    // on the backend, so it's also not typically part of the request body.

    @NotBlank(message = "Comment text cannot be empty.")
    @Size(min = 1, max = 1000, message = "Comment text must be between 1 and 1000 characters.")
    private String text;
}