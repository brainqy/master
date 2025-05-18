package com.brainqy.master.dtos;

/**
 * Description of the class or file.
 *
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @project master
 * @since 18-05-2025
 */
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TenantResponseDto {
    private String id;
    private String name;
    private String domain;
    private String customLogoUrl;
    private String primaryColor;
    private String accentColor;
    private boolean allowPublicSignup;
    private boolean communityFeedEnabled;
    private boolean jobBoardEnabled;
    private boolean gamificationEnabled;
    private boolean walletEnabled;
    private boolean eventRegistrationEnabled;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private Date createdAt;
}
