package com.abbos.hospitalmanagementsystem.dto;

import com.abbos.brainwave_matrix_intern.dto.marker.Response;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

/**
 * @author Aliabbos Ashurov
 * @since 14/January/2025  12:30
 **/
@JsonPropertyOrder({"id", "itemName", "description", "quantity", "unitPrice"})
public record InventoryItemResponseDTO(
        @NotNull Long id,

        @JsonProperty("item_name")
        @NotNull String itemName,

        String description,
        @NotNull int quantity,

        @JsonProperty("unit_price")
        @NotNull BigDecimal unitPrice

) implements Response {
}
