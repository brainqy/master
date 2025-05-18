package com.brainqy.master.entities;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.quartz.JobStoreType;

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
@Table(name = "job_openings")
public class JobOpening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String company;

    private String location;
    @Lob
    @Column(nullable = false)
    private String description;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date datePosted;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private JobStoreType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "posted_by_user_id") // FK to User table
    private User postedByUser;

    private String applicationLink;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenant_id")
    private Tenant tenant; // Job openings might be tenant-specific or platform-wide (tenantId=null)

}
