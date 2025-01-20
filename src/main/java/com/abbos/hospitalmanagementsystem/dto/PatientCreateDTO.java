package com.abbos.hospitalmanagementsystem.dto;

import com.abbos.brainwave_matrix_intern.dto.marker.Request;
import com.abbos.brainwave_matrix_intern.enums.Gender;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * @author Aliabbos Ashurov
 * @since 14/January/2025  12:50
 **/
public record PatientCreateDTO(
        @NotNull @NotBlank String firstName,
        @NotNull @NotBlank String lastName,

        @JsonProperty("date_of_birth")
        @NotNull @NotBlank String dateOfBirth,

        @NotNull Gender gender,

        @JsonProperty("phone_number")
        @NotNull @NotBlank String phoneNumber,

        String address
) implements Request {
}
