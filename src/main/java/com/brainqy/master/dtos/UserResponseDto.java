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
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDto {
    private Long id;
    private String name;
    private String email;
    private UserRole role;
    private UserStatus status;
    private String tenantId; // Or a TenantBriefDto

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
    private Gender gender;
    private String mobileNumber;
    private String currentAddress;

    private String graduationYear;
    private DegreeProgram degreeProgram;
    private String department;

    private String currentJobTitle;
    private String currentOrganization;
    private Industry industry;
    private String workLocation;
    private String linkedInProfile;
    private String yearsOfExperience;
    private List<String> skills;
    private String bio;
    private String careerInterests;
    private Set<SupportArea> areasOfSupport;
    private TimeCommitment timeCommitment;
    private EngagementMode preferredEngagementMode;
    private String otherComments;
    private SupportTypeSought lookingForSupportType;
    private String helpNeededDescription;
    private Boolean shareProfileConsent;
    private Boolean featureInSpotlightConsent;
    private Boolean isDistinguished;
    private String profilePictureUrl;
    private Integer xpPoints;
    private Integer dailyStreak;
    private Integer longestStreak;
    private Integer totalActiveDays;
    private String referralCode;
    private Set<String> earnedBadgeIds;
    private Integer interviewCredits;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private Date createdAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private Date lastLogin;
}
