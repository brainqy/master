package com.brainqy.master.repos;

import com.brainqy.master.entities.Appointment;
import com.brainqy.master.entities.AppointmentStatus;
import com.brainqy.master.entities.Tenant;
import com.brainqy.master.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Description of the class or file.
 *
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @project master
 * @since 19-05-2025
 */
@Repository
public interface TenantRepository extends JpaRepository<Tenant,Long> {
    Optional<Tenant> findByName(String name);
    boolean existsByName(String name);
    boolean existsByDomain(String domain);

    @Repository
    interface AppointmentRepository extends JpaRepository<Appointment, Long> {
        List<Appointment> findByRequesterUserOrAlumniUserOrderByDateTimeDesc(User requester, User alumni);

        // Find upcoming confirmed appointments for reminders
        List<Appointment> findByStatusAndReminderDateBeforeAndReminderSentIsFalse(
                AppointmentStatus status, Date now);

        // Add other specific finders as needed, e.g., by status, by date range for a user
    }
}
