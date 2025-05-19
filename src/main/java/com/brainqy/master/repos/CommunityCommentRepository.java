package com.brainqy.master.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brainqy.master.entities.CommunityComment;

/**
 * Description of the class or file.
 *
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @project master
 * @since 19-05-2025
 */
@Repository
public interface CommunityCommentRepository extends JpaRepository<CommunityComment, Long> {
    // Custom queries if needed, e.g., findByPostId
}
