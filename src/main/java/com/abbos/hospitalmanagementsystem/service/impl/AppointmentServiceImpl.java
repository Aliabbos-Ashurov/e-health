package com.abbos.hospitalmanagementsystem.service.impl;

import com.abbos.brainwave_matrix_intern.dto.AppointmentCreateDTO;
import com.abbos.brainwave_matrix_intern.dto.AppointmentResponseDTO;
import com.abbos.brainwave_matrix_intern.dto.AppointmentUpdateDTO;
import com.abbos.brainwave_matrix_intern.dto.Response;
import com.abbos.brainwave_matrix_intern.exception.ResourceNotFoundException;
import com.abbos.brainwave_matrix_intern.mapper.AppointmentMapper;
import com.abbos.brainwave_matrix_intern.repository.AppointmentRepository;
import com.abbos.brainwave_matrix_intern.service.AbstractService;
import com.abbos.brainwave_matrix_intern.service.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 14/January/2025  16:03
 **/
@Service
public class AppointmentServiceImpl
        extends AbstractService<AppointmentRepository, AppointmentMapper> implements AppointmentService {

    public AppointmentServiceImpl(AppointmentRepository repository, AppointmentMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public Response<List<AppointmentResponseDTO>> findAllByPatientId(Long id) {
        return Response.ok(
                repository.findAllByPatientId(id).stream()
                        .map(mapper::toDTO)
                        .toList()
        );
    }

    @Override
    public Response<List<AppointmentResponseDTO>> findAllByStaffId(Long id) {
        return Response.ok(
                repository.findAllByStaffId(id).stream()
                        .map(mapper::toDTO)
                        .toList()
        );
    }

    @Override
    public Response<AppointmentResponseDTO> create(AppointmentCreateDTO dto) {
        final var entity = mapper.fromCreate(dto);
        final var newEntity = repository.save(entity);
        return Response.ok(mapper.toDTO(newEntity));
    }

    @Override
    public Response<AppointmentResponseDTO> update(AppointmentUpdateDTO dto) {
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
    public Response<AppointmentResponseDTO> find(Long id) {
        return Response.ok(mapper.toDTO(
                repository
                        .findByIdCustom(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Appointment with id {0} not found", id))));
    }

    @Override
    public Response<List<AppointmentResponseDTO>> findAll() {
        return Response.ok(
                repository.findAllCustom().stream()
                        .map(mapper::toDTO)
                        .toList()
        );
    }
}
