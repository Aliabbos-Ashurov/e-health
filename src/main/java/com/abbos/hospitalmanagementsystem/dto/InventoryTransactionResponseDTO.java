package com.abbos.hospitalmanagementsystem.dto;

import com.abbos.hospitalmanagementsystem.dto.marker.Response;
import com.abbos.hospitalmanagementsystem.enums.TransactionType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

/**
 * @author Aliabbos Ashurov
 * @since 14/January/2025  12:36
 **/
@JsonPropertyOrder({"id", "inventoryItem", "transaction_type", "quantity", "transactionDate"})
@Schema(description = "Response DTO representing an inventory transaction, including details about the inventory item, transaction type, quantity, and date.")
public record InventoryTransactionResponseDTO(
        @NotNull Long id,

        @JsonProperty("inventory_item")
        @NotNull InventoryItemResponseDTO inventoryItem,

        @JsonProperty("transaction_type")
        @NotNull TransactionType transactionType,
        @NotNull Integer quantity,

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        @JsonProperty("transaction_date")
        @NotNull LocalDateTime transactionDate
) implements Response {
}