package com.abbos.hospitalmanagementsystem.dto;

import com.abbos.brainwave_matrix_intern.dto.marker.Request;
import com.abbos.brainwave_matrix_intern.enums.TransactionType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotNull;

/**
 * @author Aliabbos Ashurov
 * @since 14/January/2025  12:40
 **/
@JsonPropertyOrder({"inventoryID", "transactionType", "quantity"})
public record InventoryTransactionCreateDTO(
        @JsonProperty("inventory_id")
        @NotNull Long inventoryID,
        @JsonProperty("transaction_type")
        @NotNull TransactionType transactionType,
        @NotNull Integer quantity
) implements Request {
}
