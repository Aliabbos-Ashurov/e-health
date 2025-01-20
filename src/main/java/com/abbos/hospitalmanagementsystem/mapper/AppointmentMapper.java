package com.abbos.hospitalmanagementsystem.mapper;

import com.abbos.hospitalmanagementsystem.dto.AppointmentCreateDTO;
import com.abbos.hospitalmanagementsystem.dto.AppointmentResponseDTO;
import com.abbos.hospitalmanagementsystem.dto.AppointmentUpdateDTO;
import com.abbos.hospitalmanagementsystem.entity.Appointment;
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
