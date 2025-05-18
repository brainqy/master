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
@Table(name = "interview_question_comments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
class InterviewQuestionComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name="user_id") private User user;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name="question_id") private InterviewQuestion question;
    @Lob @Column(nullable = false) private String text;
    @Temporal(TemporalType.TIMESTAMP) @Column(nullable = false) private Date timestamp;
}
// File:
