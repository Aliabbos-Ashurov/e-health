package com.abbos.hospitalmanagementsystem.dto;

import com.abbos.brainwave_matrix_intern.dto.marker.Request;
import com.abbos.brainwave_matrix_intern.enums.AppointmentStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

/**
 * @author Aliabbos Ashurov
 * @since 14/January/2025  11:24
 **/
@JsonPropertyOrder({"appointmentDate"})
public record AppointmentUpdateDTO(

        @JsonProperty("appointment_date")
        @NotNull LocalDateTime appointmentDate,
        @NotNull AppointmentStatus status
) implements Request {
}
