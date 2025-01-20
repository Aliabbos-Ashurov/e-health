package com.abbos.hospitalmanagementsystem.repository;

import com.abbos.hospitalmanagementsystem.entity.InventoryTransaction;
import com.abbos.hospitalmanagementsystem.enums.TransactionType;
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
public interface InventoryTransactionRepository extends JpaRepository<InventoryTransaction, Long>, Repository {

    @Query("SELECT it FROM InventoryTransaction it WHERE it.deleted = FALSE")
    List<InventoryTransaction> findAllCustom();

    @Query("SELECT it FROM InventoryTransaction it WHERE it.id = ?1 AND it.deleted = FALSE")
    Optional<InventoryTransaction> findByIdCustom(@NotNull Long id);

    @Query("SELECT it FROM InventoryTransaction it WHERE it.deleted = FALSE")
    List<InventoryTransaction> findAllByTransactionType(@NotNull TransactionType transactionType);

    @Modifying
    @Query("UPDATE InventoryTransaction it SET it.deleted = TRUE WHERE it.id = ?1")
    void softDelete(@NotNull Long id);
}
