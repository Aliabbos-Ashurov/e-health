package com.abbos.hospitalmanagementsystem.dto;

import com.abbos.hospitalmanagementsystem.dto.marker.Request;
import jakarta.validation.constraints.NotNull;

/**
 * @author Aliabbos Ashurov
 * @since 14/January/2025  12:11
 **/
public record MedicalRecordUpdateDTO(
        @NotNull Long patientID,
        @NotNull String diagnosis
) implements Request {
}
