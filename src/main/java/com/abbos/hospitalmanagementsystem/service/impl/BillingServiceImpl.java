package com.abbos.hospitalmanagementsystem.service.impl;

import com.abbos.brainwave_matrix_intern.dto.BillingCreateDTO;
import com.abbos.brainwave_matrix_intern.dto.BillingResponseDTO;
import com.abbos.brainwave_matrix_intern.dto.BillingUpdateDTO;
import com.abbos.brainwave_matrix_intern.dto.Response;
import com.abbos.brainwave_matrix_intern.entity.Patient;
import com.abbos.brainwave_matrix_intern.enums.BillingType;
import com.abbos.brainwave_matrix_intern.exception.ResourceNotFoundException;
import com.abbos.brainwave_matrix_intern.mapper.BillingMapper;
import com.abbos.brainwave_matrix_intern.repository.BillingRepository;
import com.abbos.brainwave_matrix_intern.service.AbstractService;
import com.abbos.brainwave_matrix_intern.service.BillingService;
import com.abbos.brainwave_matrix_intern.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 14/January/2025  16:00
 **/
@Service
public class BillingServiceImpl
        extends AbstractService<BillingRepository, BillingMapper> implements BillingService {

    private final PatientService patientService;

    public BillingServiceImpl(BillingRepository repository, BillingMapper mapper, PatientService patientService) {
        super(repository, mapper);
        this.patientService = patientService;
    }

    @Override
    public Response<List<BillingResponseDTO>> findAllByPatientId(Long id) {
        return Response.ok(
                repository.findAllByPatientId(id).stream()
                        .map(mapper::toDTO)
                        .toList()
        );
    }

    @Override
    public Response<List<BillingResponseDTO>> findAllByBillingType(BillingType billingType) {
        return Response.ok(
                repository.findAllByBillingType(billingType).stream()
                        .map(mapper::toDTO)
                        .toList()
        );
    }

    @Override
    public Response<BillingResponseDTO> create(BillingCreateDTO dto) {
        final var entity = mapper.fromCreate(dto);
        Patient patient = patientService.findPatientByIdNative(dto.patientID());
        entity.setPatient(patient);
        final var newEntity = repository.save(entity);
        return Response.ok(mapper.toDTO(newEntity));
    }

    @Override
    public Response<BillingResponseDTO> update(BillingUpdateDTO dto) {
        final var entity = mapper.fromUpdate(dto);
        final var newEntity = repository.save(entity);
        return Response.ok(mapper.toDTO(newEntity));
    }

    @Override
    public Response<Boolean> delete(Long id) {
        repository.softDelete(id);
        return Response.ok(true);
    }

    @Override
    public Response<BillingResponseDTO> find(Long id) {
        return Response.ok(mapper.toDTO(
                repository
                        .findByIdCustom(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Billing with id {0} not found", id))));
    }

    @Override
    public Response<List<BillingResponseDTO>> findAll() {
        return Response.ok(
                repository.findAllCustom().stream()
                        .map(mapper::toDTO)
                        .toList()
        );
    }
}
