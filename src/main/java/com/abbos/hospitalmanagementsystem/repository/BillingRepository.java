package com.abbos.hospitalmanagementsystem.repository;

import com.abbos.hospitalmanagementsystem.entity.Billing;
import com.abbos.hospitalmanagementsystem.enums.BillingType;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * @author Aliabbos Ashurov
 * @since 14/January/2025  13:03
 **/
public interface BillingRepository extends JpaRepository<Billing, Long>, Repository {

    @Query("SELECT b FROM Billing b WHERE b.deleted = FALSE")
    List<Billing> findAllCustom();

    @Query("SELECT b FROM Billing b WHERE b.id = ?1 AND b.deleted = FALSE")
    Optional<Billing> findByIdCustom(@NotNull Long id);

    @Query("SELECT b FROM Billing b WHERE b.patient.id = ?1 AND b.deleted = FALSE")
    List<Billing> findAllByPatientId(@NotNull Long id);

    @Query("SELECT b FROM Billing b WHERE b.billingType = ?1 AND b.deleted = FALSE")
    List<Billing> findAllByBillingType(@NotNull BillingType billingType);

    @Modifying
    @Query("UPDATE Billing b SET b.deleted = TRUE WHERE b.id = ?1")
    void softDelete(@NotNull Long id);
}
