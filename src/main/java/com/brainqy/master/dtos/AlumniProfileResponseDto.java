package com.brainqy.master.dtos;

import com.brainqy.master.entities.SupportArea;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
 * @since 19-05-2025
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlumniProfileResponseDto {
    private Long id;
    private String name;
    // Email might be omitted or partially shown for privacy in a public directory
    private String email;
    private String profilePictureUrl;
    private String currentJobTitle;
    private String currentOrganization; // Or 'company'
    private String industry; // Could be User.Industry enum as String
    private String university;
    private List<String> skills;
    private String bio; // Or shortBio
    private Set<String> offersHelpWith; // Could be Set<User.SupportArea> as String
    private Integer appointmentCoinCost;
    private Boolean isDistinguished;
    private String linkedInProfile;
    private String workLocation;
    private String graduationYear;
    private Set<String> interests;
    // Add other publicly relevant fields
}