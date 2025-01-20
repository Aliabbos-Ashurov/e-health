package com.abbos.hospitalmanagementsystem.mapper;

import com.abbos.brainwave_matrix_intern.dto.*;
import com.abbos.brainwave_matrix_intern.entity.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 14/January/2025  12:57
 **/
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PatientMapper
        extends GenericMapper<Patient, PatientResponseDTO, PatientCreateDTO, PatientUpdateDTO> {

    @Mappings(
            {
                    @Mapping(target = "appointments", source = "aDTO"),
                    @Mapping(target = "medicalRecords", source = "mRDTO")
            }
    )
    PatientResponseDTO toDtoWithData(Patient patient, List<AppointmentResponseDTO> aDTO, List<MedicalRecordResponseDTO> mRDTO);
}
