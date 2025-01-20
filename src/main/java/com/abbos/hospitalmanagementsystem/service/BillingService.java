package com.abbos.hospitalmanagementsystem.service;

import com.abbos.hospitalmanagementsystem.dto.BillingCreateDTO;
import com.abbos.hospitalmanagementsystem.dto.BillingResponseDTO;
import com.abbos.hospitalmanagementsystem.dto.BillingUpdateDTO;
import com.abbos.hospitalmanagementsystem.dto.Response;
import com.abbos.hospitalmanagementsystem.entity.Billing;
import com.abbos.hospitalmanagementsystem.enums.BillingType;
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
