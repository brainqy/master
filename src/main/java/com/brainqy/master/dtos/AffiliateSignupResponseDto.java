package com.brainqy.master.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
class AffiliateSignupResponseDto {
    private Long newUserId; // Masked or partial if needed for privacy
    private String newUserName; // Masked or partial
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date signupDate;
    private Double commissionEarned;
}
