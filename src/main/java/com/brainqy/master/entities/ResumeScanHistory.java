package com.brainqy.master.entities;

/**
 * Description of the class or file.
 *
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @project master
 * @since 17-05-2025
 */
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import java.util.Date;

@Entity
@Table(name = "resume_scan_history")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ResumeScanHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenant_id", nullable = false)
    private Tenant tenant;

    @Column(length = 100)
    private String resumeIdUsed;
    @Column(length = 255)
    private String resumeNameSnapshot;

    @Column(nullable = false, length = 255)
    private String jobTitleScannedFor;
    @Column(nullable = false, length = 255)
    private String companyNameScannedFor;

    @Lob
    @Column(nullable = false)
    private String resumeTextSnapshot;
    @Lob
    @Column(nullable = false)
    private String jobDescriptionTextSnapshot;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date scanDate;

    private Integer matchScore;
    private boolean bookmarked;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String analysisResultJson;
}
// File
