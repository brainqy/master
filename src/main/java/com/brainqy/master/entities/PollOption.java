package com.brainqy.master.entities;

import jakarta.persistence.*;

/**
 * Description of the class or file.
 *
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @project master
 * @since 17-05-2025
 */
@Entity
@Table(name = "poll_options")
class PollOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    private String optionText;
    private int votes;
    @ManyToOne @JoinColumn(name="post_id") private CommunityPost post;
    // Getters and Setters
}
