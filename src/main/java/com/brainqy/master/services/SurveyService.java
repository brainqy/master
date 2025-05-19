package com.brainqy.master.services;

/**
 * Description of the class or file.
 *
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @project master
 * @since 19-05-2025
 */
import com.brainqy.master.dtos.SurveyDefinitionRequestDto;
import com.brainqy.master.dtos.SurveyDefinitionResponseDto;
import com.brainqy.master.dtos.SurveyResponseDto;
import com.brainqy.master.dtos.SurveyResponseRequestDto;

import java.util.List;

public interface SurveyService {
    SurveyDefinitionResponseDto createSurveyDefinition(Long adminUserId, SurveyDefinitionRequestDto dto);
    SurveyDefinitionResponseDto getSurveyDefinition(String surveyId, String tenantId); // For messenger to fetch
    List<SurveyDefinitionResponseDto> getAllSurveyDefinitions(String tenantId); // Admin view
    SurveyResponseDto submitSurveyResponse(Long userId, String surveyId, SurveyResponseRequestDto dto);
    List<SurveyResponseDto> getSurveyResponses(String surveyId, String tenantId); // Admin view
    // Method to determine which survey is active for a user/tenant
    SurveyDefinitionResponseDto getActiveSurveyForUser(Long userId, String tenantId);
    void setActiveSurveyForTenant(String tenantId, String surveyId); // Admin sets active survey
}
