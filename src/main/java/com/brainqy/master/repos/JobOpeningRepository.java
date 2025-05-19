package com.brainqy.master.repos;

import com.brainqy.master.entities.JobOpening;
import com.brainqy.master.entities.JobType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
public interface JobOpeningRepository extends JpaRepository<JobOpening, Long> {
    // Example of a custom query for filtering
    @Query("SELECT j FROM JobOpening j WHERE " +
            "(:title IS NULL OR lower(j.title) LIKE lower(concat('%', :title, '%'))) AND " +
            "(:company IS NULL OR lower(j.company) LIKE lower(concat('%', :company, '%'))) AND " +
            "(:location IS NULL OR lower(j.location) LIKE lower(concat('%', :location, '%'))) AND " +
            "(:type IS NULL OR j.type = :type)")
    Page<JobOpening> findByFilters(
            @Param("title") String title,
            @Param("company") String company,
            @Param("location") String location,
            @Param("type") JobType type,
            Pageable pageable
    );
    Page<JobOpening> findByTenantIdOrTenantIsNullOrderByDatePostedDesc(String tenantId, Pageable pageable); // For general listing
}
