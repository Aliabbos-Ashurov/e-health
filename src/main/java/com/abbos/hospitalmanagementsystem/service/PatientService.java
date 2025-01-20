package com.abbos.hospitalmanagementsystem.service;

import com.abbos.brainwave_matrix_intern.dto.PatientCreateDTO;
import com.abbos.brainwave_matrix_intern.dto.PatientResponseDTO;
import com.abbos.brainwave_matrix_intern.dto.PatientUpdateDTO;
import com.abbos.brainwave_matrix_intern.dto.Response;
import com.abbos.brainwave_matrix_intern.entity.Patient;
import com.abbos.brainwave_matrix_intern.enums.Gender;
import jakarta.validation.constraints.NotNull;

import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 14/January/2025  14:06
 **/
public interface PatientService
        extends GenericCrudService<Long, Patient, PatientResponseDTO, PatientCreateDTO, PatientUpdateDTO> {

    Patient findPatientByIdNative(Long id);

    Response<PatientResponseDTO> findByName(@NotNull String firstName, @NotNull String lastName);

    Response<PatientResponseDTO> findByPhoneNumber(@NotNull String phoneNumber);

    Response<List<PatientResponseDTO>> findAllByGender(@NotNull Gender gender);
}
