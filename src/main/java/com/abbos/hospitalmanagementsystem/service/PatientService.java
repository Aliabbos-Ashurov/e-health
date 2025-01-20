package com.abbos.hospitalmanagementsystem.service;

import com.abbos.hospitalmanagementsystem.dto.PatientCreateDTO;
import com.abbos.hospitalmanagementsystem.dto.PatientResponseDTO;
import com.abbos.hospitalmanagementsystem.dto.PatientUpdateDTO;
import com.abbos.hospitalmanagementsystem.dto.Response;
import com.abbos.hospitalmanagementsystem.entity.Patient;
import com.abbos.hospitalmanagementsystem.enums.Gender;
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
