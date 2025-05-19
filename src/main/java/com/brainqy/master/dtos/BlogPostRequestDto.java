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
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogPostRequestDto {
    @NotBlank(message = "Title is required")
    @Size(max = 255)
    private String title;

    @NotBlank(message = "Content is required")
    private String content; // Markdown or HTML

    @NotBlank(message = "Excerpt is required")
    @Size(max = 500) // Or based on your DB schema for excerpt
    private String excerpt;

    @URL(message = "Invalid image URL")
    @Size(max = 500)
    private String imageUrl; // Optional

    private Set<@Size(max = 50) String> tags;
}
