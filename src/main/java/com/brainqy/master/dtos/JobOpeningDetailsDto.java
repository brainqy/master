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
public class JobOpeningDetailsDto {
    private String id;
    private String title;
    private String company;
    private String description;
    private String location;
    private String type; // "Full-time", "Contract", etc.
}
