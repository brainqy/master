package com.brainqy.master.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * Description of the class or file.
 *
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @project master
 * @since 17-05-2025
 */
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
@Entity
@Table(name = "users")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false, length = 255)
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private UserRole role;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private UserStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenant_id")
    private Tenant tenant;

    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Gender gender;

    @Column(length = 20)
    private String mobileNumber;

    @Column(length = 255)
    private String currentAddress;

    @Column(length = 10)
    private String graduationYear;

    @Enumerated(EnumType.STRING)
    @Column(length = 100)
    private DegreeProgram degreeProgram;

    @Column(length = 100)
    private String department;

    @Column(length = 100)
    private String currentJobTitle;

    @Column(length = 100)
    private String currentOrganization;

    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private Industry industry;

    @Column(length = 100)
    private String workLocation;

    @Column(length = 255)
    private String linkedInProfile;

    @Column(length = 20)
    private String yearsOfExperience;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_skills", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "skill", length = 50)
    private List<String> skills;

    @Lob
    private String bio;

    @Column(length = 255)
    private String careerInterests;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_areas_of_support", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "area_of_support", length = 50)
    private Set<SupportArea> areasOfSupport;

    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private TimeCommitment timeCommitment;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_bookmarked_questions", // Name of the join table
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "question_id")
    )
    private Set<InterviewQuestion> bookmarkedQuestions = new HashSet<>();
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private EngagementMode preferredEngagementMode;

    @Lob
    private String otherComments;

    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private SupportTypeSought lookingForSupportType;

    @Lob
    private String helpNeededDescription;

    private Boolean shareProfileConsent;
    private Boolean featureInSpotlightConsent;
    private Boolean isDistinguished;

    @Column(length = 255)
    private String profilePictureUrl;

    private Integer xpPoints = 0;
    private Integer dailyStreak = 0;
    private Integer longestStreak = 0;
    private Integer totalActiveDays = 0;

    @Column(length = 50, unique = true)
    private String referralCode;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_earned_badges", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "badge_id", length = 50)
    private Set<String> earnedBadgeIds;

    private Integer interviewCredits = 0;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;

}
