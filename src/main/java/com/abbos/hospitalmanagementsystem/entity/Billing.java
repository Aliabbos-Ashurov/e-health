package com.abbos.hospitalmanagementsystem.entity;

import com.abbos.brainwave_matrix_intern.enums.BillingType;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Aliabbos Ashurov
 * @since 14/January/2025  10:56
 **/
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class Billing extends Auditable {

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @NotNull(message = "Amount is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Amount must be greater than zero")
    private BigDecimal amount;

    @Builder.Default
    @Column(name = "billing_date", nullable = false)
    private LocalDateTime billingDate = LocalDateTime.now();

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column(name = "billing_type", nullable = false)
    private BillingType billingType = BillingType.CASH;
}
