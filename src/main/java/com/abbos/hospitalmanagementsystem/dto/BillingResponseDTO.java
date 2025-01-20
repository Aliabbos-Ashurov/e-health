package com.abbos.hospitalmanagementsystem.dto;

import com.abbos.hospitalmanagementsystem.dto.marker.Response;
import com.abbos.hospitalmanagementsystem.enums.BillingType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Aliabbos Ashurov
 * @since 14/January/2025  11:25
 **/
@JsonPropertyOrder({"id", "patient", "amount", "billingDate", "billingType"})
public record BillingResponseDTO(
        @NotNull Long id,
        @NotNull PatientResponseDTO patient,
        @NotNull BigDecimal amount,

        @JsonProperty("billing_date")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        @NotNull LocalDateTime billingDate,
        @JsonProperty("billing_type")
        @NotNull BillingType billingType
) implements Response {
}
