package com.brainqy.master.dtos;

/**
 * Description of the class or file.
 *
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @project master
 * @since 19-05-2025
 */
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AffiliateDashboardResponseDto {
    private String affiliateCode;
    private String referralLink;
    private Double commissionRate;
    private Double totalEarned;
    private Integer totalClicks; // Aggregated
    private Integer totalSignups; // Aggregated
    private List<AffiliateSignupResponseDto> recentSignups; // Paginate
    // Potentially more stats
}