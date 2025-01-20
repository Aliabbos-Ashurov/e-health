package com.abbos.hospitalmanagementsystem.service;

import com.abbos.hospitalmanagementsystem.dto.InventoryTransactionCreateDTO;
import com.abbos.hospitalmanagementsystem.dto.InventoryTransactionResponseDTO;
import com.abbos.hospitalmanagementsystem.dto.InventoryTransactionUpdateDTO;
import com.abbos.hospitalmanagementsystem.dto.Response;
import com.abbos.hospitalmanagementsystem.entity.InventoryTransaction;
import com.abbos.hospitalmanagementsystem.enums.TransactionType;
import jakarta.validation.constraints.NotNull;

import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 14/January/2025  14:11
 **/
public interface InventoryTransactionService
        extends GenericCrudService<Long, InventoryTransaction, InventoryTransactionResponseDTO, InventoryTransactionCreateDTO,
        InventoryTransactionUpdateDTO> {

    Response<List<InventoryTransactionResponseDTO>> findAllByTransactionType(@NotNull TransactionType transactionType);
}
