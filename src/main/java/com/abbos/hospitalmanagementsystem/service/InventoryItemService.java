package com.abbos.hospitalmanagementsystem.service;

import com.abbos.hospitalmanagementsystem.dto.InventoryItemCreateDTO;
import com.abbos.hospitalmanagementsystem.dto.InventoryItemResponseDTO;
import com.abbos.hospitalmanagementsystem.dto.InventoryItemUpdateDTO;
import com.abbos.hospitalmanagementsystem.dto.Response;
import com.abbos.hospitalmanagementsystem.entity.InventoryItem;
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
