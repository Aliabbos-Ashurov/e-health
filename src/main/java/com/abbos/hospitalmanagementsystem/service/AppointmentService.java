package com.abbos.hospitalmanagementsystem.service;

import com.abbos.brainwave_matrix_intern.dto.AppointmentCreateDTO;
import com.abbos.brainwave_matrix_intern.dto.AppointmentResponseDTO;
import com.abbos.brainwave_matrix_intern.dto.AppointmentUpdateDTO;
import com.abbos.brainwave_matrix_intern.dto.Response;
import com.abbos.brainwave_matrix_intern.entity.Appointment;
import jakarta.validation.constraints.NotNull;

import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 14/January/2025  14:12
 **/
public interface AppointmentService
        extends GenericCrudService<Long, Appointment, AppointmentResponseDTO, AppointmentCreateDTO,
        AppointmentUpdateDTO> {

    Response<List<AppointmentResponseDTO>> findAllByPatientId(@NotNull Long id);

    Response<List<AppointmentResponseDTO>> findAllByStaffId(@NotNull Long id);
}
