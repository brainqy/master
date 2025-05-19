package com.brainqy.master.dtos;

/**
 * Description of the class or file.
 *
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @project master
 * @since 19-05-2025
 */
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
// Potentially fields like "why they want to be an affiliate", "website/social media links"
// For now, let's assume it's a simple application trigger
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AffiliateApplicationRequestDto {
    private String promotionalStrategy; // Example field
}