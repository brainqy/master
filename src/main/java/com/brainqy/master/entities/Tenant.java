package com.brainqy.master.entities;

import jakarta.persistence.*;
import lombok.*;

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
@Table(name = "tenants")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Or use String if your tenant IDs are non-numeric

    @Column(nullable = false, unique = true)
    private String name;

    @Column(unique = true)
    private String domain; // e.g., tenantA.resumematch.ai

    private String customLogoUrl;
    private String primaryColor;
    private String accentColor;
    private boolean allowPublicSignup;

    // Flags for enabled features (could be a separate settings entity if very complex)
    private boolean communityFeedEnabled;
    private boolean jobBoardEnabled;
    private boolean gamificationEnabled;
    private boolean walletEnabled;
    private boolean eventRegistrationEnabled;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    // Getters and Setters
}

