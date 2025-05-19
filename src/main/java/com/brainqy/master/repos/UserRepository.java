package com.brainqy.master.repos;

import com.brainqy.master.entities.Tenant;
import com.brainqy.master.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Description of the class or file.
 *
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @project master
 * @since 18-05-2025
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Boolean existsByEmail(String email);
    Page<User> findByTenant(Tenant tenant, Pageable pageable); // For managers
    // Add other finders as needed, e.g., findByRole, findByStatus
    // Add other custom query methods as needed
}
