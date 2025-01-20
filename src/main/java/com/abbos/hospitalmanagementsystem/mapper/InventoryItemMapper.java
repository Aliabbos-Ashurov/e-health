package com.abbos.hospitalmanagementsystem.mapper;

import com.abbos.hospitalmanagementsystem.dto.InventoryItemCreateDTO;
import com.abbos.hospitalmanagementsystem.dto.InventoryItemResponseDTO;
import com.abbos.hospitalmanagementsystem.dto.InventoryItemUpdateDTO;
import com.abbos.hospitalmanagementsystem.entity.InventoryItem;
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
