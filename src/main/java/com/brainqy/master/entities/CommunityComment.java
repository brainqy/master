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
@Table(name = "community_comments")
class CommunityComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @ManyToOne @JoinColumn(name="user_id") private User user;
    @ManyToOne @JoinColumn(name="post_id") private CommunityPost post;
    @Lob private String text;
    @Temporal(TemporalType.TIMESTAMP) private Date timestamp;
    // Getters and Setters
}
