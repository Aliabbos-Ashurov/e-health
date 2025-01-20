package com.abbos.hospitalmanagementsystem.entity;

import com.abbos.brainwave_matrix_intern.enums.AppointmentStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

/**
 * @author Aliabbos Ashurov
 * @since 14/January/2025  10:52
 **/
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class Appointment extends Auditable {

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "staff_id", nullable = false)
    private User staff;

    @NotNull(message = "Appointment date is required")
    @Column(name = "appointment_date", nullable = false)
    private LocalDateTime appointmentDate;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @NotBlank(message = "Status is required")
    private AppointmentStatus status = AppointmentStatus.SCHEDULED;
}