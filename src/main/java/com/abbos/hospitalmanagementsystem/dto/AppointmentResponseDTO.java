package com.abbos.hospitalmanagementsystem.dto;

import com.abbos.hospitalmanagementsystem.dto.marker.Response;
import com.abbos.hospitalmanagementsystem.entity.User;
import com.abbos.hospitalmanagementsystem.enums.AppointmentStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

/**
 * @author Aliabbos Ashurov
 * @since 14/January/2025  11:19
 **/
@JsonPropertyOrder({"id", "patient", "staff", "appointmentDate", "status"})
@Schema(description = "Response DTO representing an appointment, including details about the patient, staff, appointment date, and status.")
public record AppointmentResponseDTO(
        @NotNull Long id,
        @NotNull PatientResponseDTO patient,
        @NotNull User staff,

        @JsonProperty("appointmentDate")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        @NotNull LocalDateTime appointmentDate,

        @NotNull AppointmentStatus status
) implements Response {
}
