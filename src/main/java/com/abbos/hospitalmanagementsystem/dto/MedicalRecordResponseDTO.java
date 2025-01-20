package com.abbos.hospitalmanagementsystem.dto;

import com.abbos.brainwave_matrix_intern.dto.marker.Response;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

/**
 * @author Aliabbos Ashurov
 * @since 14/January/2025  11:38
 **/
@JsonPropertyOrder({"id", "patient", "diagnosis", "prescription", "notes"})
@Schema(description = "Response DTO representing a medical record, containing information about the patient, diagnosis, prescription, and notes.")
public record MedicalRecordResponseDTO(
        @NotNull Long id,
        @NotNull PatientResponseDTO patient,
        @NotNull String diagnosis,
        String prescription,
        String notes
) implements Response {
}