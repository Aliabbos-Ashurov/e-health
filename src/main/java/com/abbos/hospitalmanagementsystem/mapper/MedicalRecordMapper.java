package com.abbos.hospitalmanagementsystem.mapper;

import com.abbos.hospitalmanagementsystem.dto.MedicalRecordCreateDTO;
import com.abbos.hospitalmanagementsystem.dto.MedicalRecordResponseDTO;
import com.abbos.hospitalmanagementsystem.dto.MedicalRecordUpdateDTO;
import com.abbos.hospitalmanagementsystem.entity.MedicalRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

/**
 * @author Aliabbos Ashurov
 * @since 14/January/2025  12:58
 **/
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MedicalRecordMapper
        extends GenericMapper<MedicalRecord, MedicalRecordResponseDTO, MedicalRecordCreateDTO, MedicalRecordUpdateDTO> {

    @Override
    @Mapping(target = "patient", ignore = true)
    MedicalRecordResponseDTO toDTO(MedicalRecord medicalRecord);
}
