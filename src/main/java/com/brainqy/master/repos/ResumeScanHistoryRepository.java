package com.brainqy.master.repos;

/**
 * Description of the class or file.
 *
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @project master
 * @since 19-05-2025
 */
import com.brainqy.master.entities.ResumeScanHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ResumeScanHistoryRepository extends JpaRepository<ResumeScanHistory, Long> {
    Page<ResumeScanHistory> findByUserIdOrderByScanDateDesc(Long userId, Pageable pageable);
    List<ResumeScanHistory> findByUserIdAndBookmarkedTrueOrderByScanDateDesc(Long userId);
    // Potentially methods to filter by score ranges if needed
}
