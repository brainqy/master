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
@Table(name = "job_applications")
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private String jobTitle;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private JobApplicationStatus status;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dateApplied;

    @Lob
    private String notes;
    @Lob
    private String jobDescription;
    private String location;
    private String applicationUrl;

    @Temporal(TemporalType.TIMESTAMP)
    private Date reminderDate;

    private String sourceJobOpeningId; // If linked from internal job board

}