package com.brainqy.master.services;

import com.brainqy.master.dtos.*;

/**
 * Description of the class or file.
 *
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @project master
 * @since 19-05-2025
 */
public interface AIService {
    AnalyzeResumeAndJobDescriptionResponseDto performResumeAnalysis(AnalyzeResumeAndJobDescriptionRequestDto input);
    GenerateResumeVariantResponseDto performResumeVariantGeneration(GenerateResumeVariantRequestDto input);
    GenerateCoverLetterResponseDto performCoverLetterGeneration(GenerateCoverLetterRequestDto input);
    PersonalizedJobRecommendationsResponseDto performJobRecommendation(PersonalizedJobRecommendationsRequestDto input);
    SuggestDynamicSkillsResponseDto performDynamicSkillSuggestion(SuggestDynamicSkillsRequestDto input);
    GenerateAiBlogPostResponseDto performAiBlogPostGeneration(GenerateAiBlogPostRequestDto input);
    GenerateMockInterviewQuestionsResponseDto performMockInterviewQuestionGeneration(GenerateMockInterviewQuestionsRequestDto input);
    EvaluateInterviewAnswerResponseDto performInterviewAnswerEvaluation(EvaluateInterviewAnswerRequestDto input);
    GenerateOverallInterviewFeedbackResponseDto performOverallInterviewFeedbackGeneration(GenerateOverallInterviewFeedbackRequestDto input);
    GenerateRegionSummaryResponseDto performRegionSummaryGeneration(GenerateRegionSummaryRequestDto input); // Assuming types for this
}
