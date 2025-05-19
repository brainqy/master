package com.brainqy.master.services;

/**
 * Description of the class or file.
 *
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @project master
 * @since 19-05-2025
 */
import com.brainqy.master.dtos.*;

import java.util.List;

public interface EngagementService {
    // Gamification - User facing
    UserGamificationProfileDto getUserGamificationProfile(Long userId); // XP, level, streak, earned badges
    List<BadgeResponseDto> getAllBadges(); // For display
    List<LeaderboardUserDto> getLeaderboard(int topN);

    // Gamification - Admin facing for rules
    GamificationRuleResponseDto createGamificationRule(GamificationRuleRequestDto dto);
    List<GamificationRuleResponseDto> getAllGamificationRules();
    GamificationRuleResponseDto updateGamificationRule(String actionId, GamificationRuleRequestDto dto);
    void deleteGamificationRule(String actionId);
    BadgeResponseDto createBadge(BadgeRequestDto dto);
    BadgeResponseDto updateBadge(String badgeId, BadgeRequestDto dto);
    void deleteBadge(String badgeId);
    void awardXp(Long userId, String actionId); // Internal method called by other services

    // Wallet
    WalletResponseDto getUserWallet(Long userId);
    WalletTransactionResponseDto addFundsToWallet(Long userId, AddFundsRequestDto dto); // Mocked for now
    void deductCoinsForService(Long userId, int amount, String description); // Internal

    // Referrals
    UserReferralInfoResponseDto getUserReferralInfo(Long userId);
    // Logic for processing new signups via referral code would be in AuthService or UserService

    // Affiliates - User facing (application)
    AffiliateResponseDto applyForAffiliateProgram(Long userId, AffiliateApplicationRequestDto dto);
    AffiliateDashboardResponseDto getAffiliateDashboard(Long userId); // Their stats

    // Affiliates - Admin facing
    List<AffiliateResponseDto> getAllAffiliatesAdmin(String statusFilter);
    AffiliateResponseDto updateAffiliateStatus(Long adminUserId, Long affiliateUserId, String newStatus);
    // Payouts, detailed affiliate stats for admin would also go here
}
