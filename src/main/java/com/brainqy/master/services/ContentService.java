package com.brainqy.master.services;

import com.brainqy.master.dtos.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Description of the class or file.
 *
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @project master
 * @since 19-05-2025
 */
public interface ContentService {
    // Blog Posts
    BlogPostResponseDto createBlogPost(Long userId, String tenantId, BlogPostRequestDto dto);
    Page<BlogPostResponseDto> getAllBlogPosts(String tenantId, String tagFilter, Pageable pageable);
    BlogPostResponseDto getBlogPostBySlug(String slug);
    BlogPostResponseDto updateBlogPost(Long userId, Long postId, BlogPostRequestDto dto);
    void deleteBlogPost(Long userId, Long postId);
    BlogCommentResponseDto addBlogComment(Long userId, Long postId, BlogCommentRequestDto dto);

    // Gallery Events
    GalleryEventResponseDto createGalleryEvent(Long userId, String tenantId, GalleryEventRequestDto dto);
    Page<GalleryEventResponseDto> getAllGalleryEvents(String tenantId, Pageable pageable);
    GalleryEventResponseDto updateGalleryEvent(Long userId, Long eventId, GalleryEventRequestDto dto);
    void deleteGalleryEvent(Long userId, Long eventId);
    List<UserResponseDto> getGalleryEventAttendees(Long eventId); // If authorized

    // Announcements
    AnnouncementResponseDto createAnnouncement(Long adminUserId, AnnouncementRequestDto dto);
    List<AnnouncementResponseDto> getActiveAnnouncementsForUser(Long userId, String tenantId, String userRole);
    Page<AnnouncementResponseDto> getAllAnnouncementsAdmin(String tenantId, Pageable pageable); // Admin view
    AnnouncementResponseDto updateAnnouncement(Long adminUserId, Long announcementId, AnnouncementRequestDto dto);
    void deleteAnnouncement(Long adminUserId, Long announcementId);

    // Feature Requests
    FeatureRequestResponseDto submitFeatureRequest(Long userId, String tenantId, FeatureRequestCreateDto dto);
    Page<FeatureRequestResponseDto> getAllFeatureRequests(String statusFilter, Pageable pageable); // Admin/Public view
    FeatureRequestResponseDto getFeatureRequestById(Long requestId);
    FeatureRequestResponseDto updateFeatureRequestStatus(Long adminUserId, Long requestId, String newStatus);
    FeatureRequestResponseDto upvoteFeatureRequest(Long userId, Long requestId);
    FeatureRequestResponseDto updateFeatureRequest(Long userId, Long requestId, FeatureRequestUpdateDto dto); // User edits their own
}
