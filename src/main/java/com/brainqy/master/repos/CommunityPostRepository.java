package com.brainqy.master.repos;

import com.brainqy.master.entities.CommunityPost;
import com.brainqy.master.entities.Tenant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Description of the class or file.
 *
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @project master
 * @since 19-05-2025
 */
@Repository
public interface CommunityPostRepository extends JpaRepository<CommunityPost, Long> {
    Page<CommunityPost> findByTenantAndModerationStatusNotOrderByTimestampDesc(Tenant tenant, CommunityPost.ModerationStatus excludedStatus, Pageable pageable);
    Page<CommunityPost> findByTenantAndTypeAndModerationStatusNotOrderByTimestampDesc(Tenant tenant, CommunityPost.PostType type, CommunityPost.ModerationStatus excludedStatus, Pageable pageable);
    Page<CommunityPost> findByTenantAndAuthorIdAndModerationStatusNotOrderByTimestampDesc(Tenant tenant, Long authorId, CommunityPost.ModerationStatus excludedStatus, Pageable pageable);
    Page<CommunityPost> findByTenantAndModerationStatusOrderByTimestampDesc(Tenant tenant, CommunityPost.ModerationStatus status, Pageable pageable); // For mods
    // Platform-wide versions if needed (e.g., for admins or if some posts are global)
    Page<CommunityPost> findByModerationStatusNotOrderByTimestampDesc(CommunityPost.ModerationStatus excludedStatus, Pageable pageable);
}
