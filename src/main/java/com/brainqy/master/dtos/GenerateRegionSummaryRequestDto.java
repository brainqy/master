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
public class GenerateRegionSummaryRequestDto {
    private String region;
    private String language; // e.g., "en", "hi", "mr"
    private String dataPoints; // e.g., "Population: 1.6M, Median Income: $105k"
}