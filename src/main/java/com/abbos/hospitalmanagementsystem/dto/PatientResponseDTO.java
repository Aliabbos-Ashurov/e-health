package com.abbos.hospitalmanagementsystem.dto;

import com.abbos.brainwave_matrix_intern.dto.marker.Response;
import com.abbos.brainwave_matrix_intern.enums.Gender;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 14/January/2025  11:20
 **/
@JsonPropertyOrder({"id", "firstName", "lastName", "dateOfBirth", "gender", "phoneNumber",
        "address", "appointments", "medicalRecords"})
@Schema(description = "Patient Response DTO containing basic details about a patient, their appointments, and medical records.")
public record PatientResponseDTO(
        @NotNull Long id,
        @NotNull @NotBlank String firstName,
        @NotNull @NotBlank String lastName,

        @JsonProperty("date_of_birth")
        @NotNull @NotBlank String dateOfBirth,

        @NotNull Gender gender,

        @JsonProperty("phone_number")
        @NotNull @NotBlank String phoneNumber,

        String address,
        @NotNull List<AppointmentResponseDTO> appointments,

        @JsonProperty("medical_records")
        @NotNull List<MedicalRecordResponseDTO> medicalRecords
) implements Response {
}