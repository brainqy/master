package com.brainqy.master.services;

import com.brainqy.master.dtos.CommunityCommentRequestDto;
import com.brainqy.master.dtos.CommunityCommentResponseDto;
/**
 * Description of the class or file.
 *
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @project master
 * @since 19-05-2025
 */
import com.brainqy.master.dtos.CommunityPostRequestDto;
import com.brainqy.master.dtos.CommunityPostResponseDto;
import com.brainqy.master.entities.CommunityPost.PostType;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommunityService {
    CommunityPostResponseDto createPost(Long userId, String tenantId, CommunityPostRequestDto dto);
    Page<CommunityPostResponseDto> getFeedPosts(String tenantId, PostType filterType, Long currentUserId, Pageable pageable);
    CommunityPostResponseDto getPostById(Long postId);
    CommunityPostResponseDto updatePost(Long userId, Long postId, CommunityPostRequestDto dto);
    void deletePost(Long userId, Long postId);

    CommunityCommentResponseDto addComment(Long userId, Long postId, CommunityCommentRequestDto dto);
    void deleteComment(Long userId, Long commentId);

    CommunityPostResponseDto voteOnPoll(Long userId, Long postId, int optionIndex);
    CommunityPostResponseDto registerForEvent(Long userId, Long postId);
    CommunityPostResponseDto assignRequest(Long userId, Long postId);

    // Moderation
    void flagPost(Long userId, Long postId);
    CommunityPostResponseDto approvePost(Long moderatorId, Long postId);
    CommunityPostResponseDto removePost(Long moderatorId, Long postId);
    Page<CommunityPostResponseDto> getFlaggedPosts(String tenantId, Pageable pageable); // For mods
}
