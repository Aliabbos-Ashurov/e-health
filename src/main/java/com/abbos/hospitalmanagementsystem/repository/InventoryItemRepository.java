package com.abbos.hospitalmanagementsystem.repository;

import com.abbos.hospitalmanagementsystem.entity.InventoryItem;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * @author Aliabbos Ashurov
 * @since 14/January/2025  13:03
 **/
public interface InventoryItemRepository extends JpaRepository<InventoryItem, Integer>, Repository {

    @Query("SELECT it FROM InventoryItem it WHERE it.deleted = FALSE")
    List<InventoryItem> findAllCustom();

    @Query("SELECT it FROM InventoryItem it WHERE it.id = ?1 AND it.deleted = FALSE")
    Optional<InventoryItem> findByIdCustom(@NotNull Long id);

    @Query("SELECT it FROM InventoryItem it WHERE it.itemName ILIKE %:name% AND it.deleted = FALSE")
    List<InventoryItem> findAllByName(@NotNull @NotBlank @Param("name") String name);

    @Modifying
    @Query("UPDATE InventoryItem it SET it.deleted = TRUE WHERE it.id = ?1")
    void softDelete(@NotNull Long id);
}
