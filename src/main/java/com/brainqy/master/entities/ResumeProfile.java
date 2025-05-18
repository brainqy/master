package com.brainqy.master.entities;

import jakarta.persistence.*;

import java.util.Date;

/**
 * Description of the class or file.
 *
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @project master
 * @since 17-05-2025
 */
@Entity
@Table(name = "resume_profiles")
public class ResumeProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String name; // e.g., "Software Engineer Resume v2"

    @Lob // For long text
    @Column(nullable = false)
    private String resumeText;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastAnalyzed;

    // Getters and Setters
}

