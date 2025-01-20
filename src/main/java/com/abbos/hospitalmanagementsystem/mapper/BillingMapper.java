package com.abbos.hospitalmanagementsystem.mapper;

import com.abbos.brainwave_matrix_intern.dto.BillingCreateDTO;
import com.abbos.brainwave_matrix_intern.dto.BillingResponseDTO;
import com.abbos.brainwave_matrix_intern.dto.BillingUpdateDTO;
import com.abbos.brainwave_matrix_intern.entity.Billing;
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
