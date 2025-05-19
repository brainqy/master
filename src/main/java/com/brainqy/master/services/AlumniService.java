package com.brainqy.master.services;

import com.brainqy.master.dtos.AlumniProfileResponseDto;
/**
 * Description of the class or file.
 *
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @project master
 * @since 19-05-2025
 */
import com.brainqy.master.dtos.AppointmentRequestDto;
import com.brainqy.master.dtos.AppointmentResponseDto;
import com.brainqy.master.dtos.FeedbackRequestDto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface AlumniService {
    Page<AlumniProfileResponseDto> getAllAlumni(String tenantId, List<String> skills, List<String> companies, List<String> universities, String searchTerm, Pageable pageable);
    AlumniProfileResponseDto getAlumniProfileById(Long alumniUserId);
    AlumniProfileResponseDto markAlumnusDistinguished(Long adminUserId, Long alumniUserId, boolean isDistinguished);

    // Appointment related methods (could also be in a separate AppointmentService)
    AppointmentResponseDto requestAppointment(Long requesterUserId, AppointmentRequestDto dto);
    List<AppointmentResponseDto> getUserAppointments(Long userId);
    AppointmentResponseDto getAppointmentById(Long userId, Long appointmentId);
    AppointmentResponseDto confirmAppointment(Long alumniUserId, Long appointmentId); // Alumni confirms
    AppointmentResponseDto cancelAppointment(Long userId, Long appointmentId); // Requester or Alumni cancels
    AppointmentResponseDto completeAppointment(Long userId, Long appointmentId);
    void submitAppointmentFeedback(Long userId, Long appointmentId, FeedbackRequestDto dto);
    AppointmentResponseDto rescheduleAppointmentRequest(Long userId, Long appointmentId, AppointmentRequestDto rescheduleDto);
    // Method for system to send reminders (called by a scheduler)
    void sendAppointmentReminders();
}