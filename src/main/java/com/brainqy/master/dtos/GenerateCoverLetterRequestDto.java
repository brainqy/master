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

@Data
public class GenerateCoverLetterRequestDto {
    private String userProfileText;
    private String jobDescriptionText;
    private String companyName;
    private String jobTitle;
    private String userName;
    private String additionalNotes;
}
