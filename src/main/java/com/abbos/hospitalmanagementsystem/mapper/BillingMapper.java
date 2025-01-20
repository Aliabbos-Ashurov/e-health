package com.abbos.hospitalmanagementsystem.mapper;

import com.abbos.hospitalmanagementsystem.dto.BillingCreateDTO;
import com.abbos.hospitalmanagementsystem.dto.BillingResponseDTO;
import com.abbos.hospitalmanagementsystem.dto.BillingUpdateDTO;
import com.abbos.hospitalmanagementsystem.entity.Billing;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
 * @author Aliabbos Ashurov
 * @since 14/January/2025  13:00
 **/
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BillingMapper
        extends GenericMapper<Billing, BillingResponseDTO, BillingCreateDTO, BillingUpdateDTO> {
}
