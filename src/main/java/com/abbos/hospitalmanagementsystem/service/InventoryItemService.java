package com.abbos.hospitalmanagementsystem.service;

import com.abbos.brainwave_matrix_intern.dto.InventoryItemCreateDTO;
import com.abbos.brainwave_matrix_intern.dto.InventoryItemResponseDTO;
import com.abbos.brainwave_matrix_intern.dto.InventoryItemUpdateDTO;
import com.abbos.brainwave_matrix_intern.dto.Response;
import com.abbos.brainwave_matrix_intern.entity.InventoryItem;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 14/January/2025  14:11
 **/
public interface InventoryItemService
        extends GenericCrudService<Long, InventoryItem, InventoryItemResponseDTO, InventoryItemCreateDTO,
        InventoryItemUpdateDTO> {

    Response<List<InventoryItemResponseDTO>> findAllByName(@NotNull @NotBlank String name);
}
