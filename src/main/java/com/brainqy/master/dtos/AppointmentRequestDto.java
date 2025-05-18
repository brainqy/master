package com.brainqy.master.dtos;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Description of the class or file.
 *
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @project master
 * @since 18-05-2025
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentRequestDto {

    @NotNull(message = "Alumni user ID is required")
    private Long alumniUserId; // ID of the user being booked

    @NotBlank(message = "Appointment title/purpose is required")
    @Size(max = 255)
    private String title; // Or purpose

    @NotNull(message = "Date and time are required")
    @FutureOrPresent(message = "Appointment date must be in the present or future")
    private Date dateTime; // Send as ISO string or timestamp

    @Lob
    @Size(max = 1000)
    private String message; // Optional message to the alumni
}
