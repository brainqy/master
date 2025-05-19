package com.brainqy.master.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * Description of the class or file.
 *
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @project master
 * @since 19-05-2025
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserGamificationProfileDto {
    private Long userId;
    private String userName;
    private Integer xpPoints;
    private Integer level;
    private Integer xpToNextLevel;
    private Integer xpCurrentLevelProgress; // XP within the current level
    private Integer dailyStreak;
    private Integer longestStreak;
    private Set<String> earnedBadgeIds; // Or List<BadgeResponseDto>
}