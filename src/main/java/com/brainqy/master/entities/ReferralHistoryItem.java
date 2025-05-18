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
@Table(name = "referral_history")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ReferralHistoryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "referrer_user_id", nullable = false)
    private User referrerUser;

    @Column(length = 100)
    private String referredEmailOrName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "referred_user_id")
    private User referredUser;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date referralDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private ReferralStatus status;

    private Integer rewardAmount;

    public enum ReferralStatus { PENDING, SIGNED_UP, REWARD_EARNED, EXPIRED }
}
//