package com.abbos.hospitalmanagementsystem.service;

import com.abbos.brainwave_matrix_intern.dto.InventoryTransactionCreateDTO;
import com.abbos.brainwave_matrix_intern.dto.InventoryTransactionResponseDTO;
import com.abbos.brainwave_matrix_intern.dto.InventoryTransactionUpdateDTO;
import com.abbos.brainwave_matrix_intern.dto.Response;
import com.abbos.brainwave_matrix_intern.entity.InventoryTransaction;
import com.abbos.brainwave_matrix_intern.enums.TransactionType;
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
