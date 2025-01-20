package com.abbos.hospitalmanagementsystem.mapper;

import com.abbos.brainwave_matrix_intern.dto.AppointmentCreateDTO;
import com.abbos.brainwave_matrix_intern.dto.AppointmentResponseDTO;
import com.abbos.brainwave_matrix_intern.dto.AppointmentUpdateDTO;
import com.abbos.brainwave_matrix_intern.entity.Appointment;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
 * @author Aliabbos Ashurov
 * @since 14/January/2025  13:01
 **/
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AppointmentMapper
        extends GenericMapper<Appointment, AppointmentResponseDTO, AppointmentCreateDTO, AppointmentUpdateDTO> {
}
