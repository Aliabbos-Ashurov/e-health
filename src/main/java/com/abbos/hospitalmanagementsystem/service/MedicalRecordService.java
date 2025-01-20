package com.abbos.hospitalmanagementsystem.service;

import com.abbos.brainwave_matrix_intern.dto.MedicalRecordCreateDTO;
import com.abbos.brainwave_matrix_intern.dto.MedicalRecordResponseDTO;
import com.abbos.brainwave_matrix_intern.dto.MedicalRecordUpdateDTO;
import com.abbos.brainwave_matrix_intern.dto.Response;
import com.abbos.brainwave_matrix_intern.entity.MedicalRecord;
import jakarta.validation.constraints.NotNull;

import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 14/January/2025  14:07
 **/
public interface MedicalRecordService
        extends GenericCrudService<Long, MedicalRecord, MedicalRecordResponseDTO, MedicalRecordCreateDTO,
        MedicalRecordUpdateDTO> {

    Response<MedicalRecordResponseDTO> findByPatientId(@NotNull Long id);

    Response<List<MedicalRecordResponseDTO>> findByDiagnosis(String diagnosis);
}
