package com.brainqy.master.dtos;

/**
 * Description of the class or file.
 *
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @project master
 * @since 17-05-2025
 */
import com.brainqy.master.entities.*;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileUpdateRequestDto {
    // Only fields a user can update on their own profile
    @Size(min = 2, max = 100)
    private String name;

    private Date dateOfBirth; // Consider using String and parsing in service if date format is tricky
    private Gender gender;
    @Size(max = 20)
    private String mobileNumber;
    @Size(max = 255)
    private String currentAddress;
    @Size(max = 10)
    private String graduationYear;
    private DegreeProgram degreeProgram;
    @Size(max = 100)
    private String department;
    @Size(max = 100)
    private String currentJobTitle;
    @Size(max = 100)
    private String currentOrganization;
    private Industry industry;
    @Size(max = 100)
    private String workLocation;
    @Size(max = 255)
    @org.hibernate.validator.constraints.URL(message = "Invalid LinkedIn URL format") // Example using Hibernate Validator for URL
    private String linkedInProfile;
    @Size(max = 20)
    private String yearsOfExperience;
    private List<String> skills; // Client might send as comma-separated string, service converts to List
    @Size(max = 2000)
    private String bio;
    @Size(max = 255)
    private String careerInterests;
    private Set<SupportArea> areasOfSupport;
    private TimeCommitment timeCommitment;
    private EngagementMode preferredEngagementMode;
    @Size(max = 1000)
    private String otherComments;
    private SupportTypeSought lookingForSupportType;
    @Size(max = 1000)
    private String helpNeededDescription;
    private Boolean shareProfileConsent;
    private Boolean featureInSpotlightConsent;
    @Size(max = 255)
    @org.hibernate.validator.constraints.URL(message = "Invalid profile picture URL format")
    private String profilePictureUrl;
    @Lob // If resumeText is directly updatable via profile (consider separate endpoint for large text)
    private String resumeText;
}