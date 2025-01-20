package com.abbos.hospitalmanagementsystem.mapper;

import com.abbos.brainwave_matrix_intern.dto.InventoryTransactionCreateDTO;
import com.abbos.brainwave_matrix_intern.dto.InventoryTransactionResponseDTO;
import com.abbos.brainwave_matrix_intern.dto.InventoryTransactionUpdateDTO;
import com.abbos.brainwave_matrix_intern.entity.InventoryTransaction;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
 * @author Aliabbos Ashurov
 * @since 14/January/2025  12:59
 **/
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface InventoryTransactionMapper
        extends GenericMapper<InventoryTransaction, InventoryTransactionResponseDTO,
        InventoryTransactionCreateDTO, InventoryTransactionUpdateDTO> {
}
