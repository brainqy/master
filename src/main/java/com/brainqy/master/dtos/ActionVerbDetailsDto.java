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
class ActionVerbDetailsDto {
    private Integer score;
    private List<String> strongVerbsUsed;
    private List<String> weakVerbsUsed;
    private List<String> overusedVerbs;
    private List<SuggestedVerbDto> suggestedStrongerVerbs;
}