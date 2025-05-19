package com.brainqy.master.repos;

/**
 * Description of the class or file.
 *
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @project master
 * @since 19-05-2025
 */
import com.brainqy.master.entities.ResumeProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ResumeProfileRepository extends JpaRepository<ResumeProfile, Long> {
    List<ResumeProfile> findByUserId(Long userId);
}
