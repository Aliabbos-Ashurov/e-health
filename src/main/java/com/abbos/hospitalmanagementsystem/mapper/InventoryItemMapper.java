package com.abbos.hospitalmanagementsystem.mapper;

import com.abbos.brainwave_matrix_intern.dto.InventoryItemCreateDTO;
import com.abbos.brainwave_matrix_intern.dto.InventoryItemResponseDTO;
import com.abbos.brainwave_matrix_intern.dto.InventoryItemUpdateDTO;
import com.abbos.brainwave_matrix_intern.entity.InventoryItem;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
 * @author Aliabbos Ashurov
 * @since 14/January/2025  13:00
 **/
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface InventoryItemMapper
        extends GenericMapper<InventoryItem, InventoryItemResponseDTO, InventoryItemCreateDTO, InventoryItemUpdateDTO> {
}
