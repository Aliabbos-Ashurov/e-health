package com.abbos.hospitalmanagementsystem.dto;

import com.abbos.hospitalmanagementsystem.dto.marker.Request;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotNull;

/**
 * @author Aliabbos Ashurov
 * @since 14/January/2025  11:40
 **/
@JsonPropertyOrder({"patientID", "diagnosis", "prescription", "notes"})
public record MedicalRecordCreateDTO(

        @JsonProperty("patient_id")
        @NotNull Long patientID,
        @NotNull String diagnosis,
        String prescription,
        String notes
) implements Request {
}
