package com.brainqy.master.entities;

import jakarta.persistence.*;

import java.util.Date;
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
@Entity
@Table(name = "community_posts")
public class CommunityPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenant_id", nullable = false)
    private Tenant tenant;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date timestamp;

    @Lob
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PostType type;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "post_tags", joinColumns = @JoinColumn(name = "post_id"))
    @Column(name = "tag")
    private Set<String> tags;

    // For Polls
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "post")
    private List<PollOption> pollOptions;

    // For Events
    private String eventTitle;
    @Temporal(TemporalType.TIMESTAMP)
    private Date eventDate;
    private String eventLocation;
    private Integer attendees;
    private Integer capacity;

    // For Requests
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assigned_to_user_id")
    private User assignedTo;
    @Enumerated(EnumType.STRING)
    private RequestStatus requestStatus;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ModerationStatus moderationStatus;
    private int flagCount;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "post")
    @OrderBy("timestamp ASC")
    private List<CommunityComment> comments;

    // Getters and Setters

    public enum PostType { TEXT, POLL, EVENT, REQUEST }
    public enum RequestStatus { OPEN, ASSIGNED, COMPLETED }
    public enum ModerationStatus { VISIBLE, FLAGGED, REMOVED }
}
