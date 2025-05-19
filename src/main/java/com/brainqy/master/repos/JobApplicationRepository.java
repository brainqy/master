package com.brainqy.master.repos;

import com.brainqy.master.entities.JobApplication;
import com.brainqy.master.entities.JobApplicationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Description of the class or file.
 *
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @project master
 * @since 19-05-2025
 */
@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplication,Long> {
    List<JobApplication> findByUserIdOrderByDateAppliedDesc(Long userId);
    List<JobApplication> findByUserIdAndStatus(Long userId, JobApplicationStatus status);
}
