package com.brainqy.master.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
public class UserReferralInfoResponseDto {
    private String referralCode;
    private String referralLink; // Constructed by backend
    private List<ReferralHistoryItemResponseDto> history; // Paginate in real app
}
