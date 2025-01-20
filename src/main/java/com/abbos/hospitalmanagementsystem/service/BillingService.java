package com.abbos.hospitalmanagementsystem.service;

import com.abbos.brainwave_matrix_intern.dto.BillingCreateDTO;
import com.abbos.brainwave_matrix_intern.dto.BillingResponseDTO;
import com.abbos.brainwave_matrix_intern.dto.BillingUpdateDTO;
import com.abbos.brainwave_matrix_intern.dto.Response;
import com.abbos.brainwave_matrix_intern.entity.Billing;
import com.abbos.brainwave_matrix_intern.enums.BillingType;
import jakarta.validation.constraints.NotNull;

import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 14/January/2025  14:12
 **/
public interface BillingService
        extends GenericCrudService<Long, Billing, BillingResponseDTO, BillingCreateDTO, BillingUpdateDTO> {

    Response<List<BillingResponseDTO>> findAllByPatientId(@NotNull Long id);

    Response<List<BillingResponseDTO>> findAllByBillingType(@NotNull BillingType billingType);
}
