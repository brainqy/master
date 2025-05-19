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
import java.util.List;

@Data
public class GenerateAiBlogPostRequestDto {
    private String topic;
    private String style; // "informative", "casual", etc.
    private String targetAudience;
    private List<String> keywords;
}

