package com.abbos.hospitalmanagementsystem.entity;

import com.abbos.brainwave_matrix_intern.enums.TransactionType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

/**
 * @author Aliabbos Ashurov
 * @since 14/January/2025  10:58
 **/
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class InventoryTransaction extends Auditable {

    @ManyToOne
    @JoinColumn(name = "inventory_item_id", nullable = false)
    private InventoryItem inventoryItem;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @NotBlank(message = "Transaction type is required")
    @Column(name = "transaction_type")
    private TransactionType transactionType = TransactionType.PURCHASE;

    @NotNull(message = "Quantity is required")
    @Min(value = 1, message = "Transaction quantity must be at least 1")
    private Integer quantity;

    @Builder.Default
    @Column(name = "transaction_date", nullable = false)
    private LocalDateTime transactionDate = LocalDateTime.now();
}
