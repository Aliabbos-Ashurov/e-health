package com.abbos.hospitalmanagementsystem.service.impl;

import com.abbos.brainwave_matrix_intern.dto.MedicalRecordCreateDTO;
import com.abbos.brainwave_matrix_intern.dto.MedicalRecordResponseDTO;
import com.abbos.brainwave_matrix_intern.dto.MedicalRecordUpdateDTO;
import com.abbos.brainwave_matrix_intern.dto.Response;
import com.abbos.brainwave_matrix_intern.entity.Patient;
import com.abbos.brainwave_matrix_intern.exception.ResourceNotFoundException;
import com.abbos.brainwave_matrix_intern.mapper.MedicalRecordMapper;
import com.abbos.brainwave_matrix_intern.repository.MedicalRecordRepository;
import com.abbos.brainwave_matrix_intern.service.AbstractService;
import com.abbos.brainwave_matrix_intern.service.MedicalRecordService;
import com.abbos.brainwave_matrix_intern.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 14/January/2025  15:48
 **/
@Service
public class MedicalRecordServiceImpl
        extends AbstractService<MedicalRecordRepository, MedicalRecordMapper> implements MedicalRecordService {

    private final PatientService patientService;

    public MedicalRecordServiceImpl(MedicalRecordRepository repository, MedicalRecordMapper mapper, PatientService patientService) {
        super(repository, mapper);
        this.patientService = patientService;
    }

    @Override
    public Response<MedicalRecordResponseDTO> findByPatientId(Long id) {
        return Response.ok(mapper.toDTO(repository.findByPatientId(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id: {0} ", id))));
    }

    @Override
    public Response<List<MedicalRecordResponseDTO>> findByDiagnosis(String diagnosis) {
        return Response.ok(repository.findByDiagnosis(diagnosis).stream()
                .map(mapper::toDTO)
                .toList());
    }

    @Override
    public Response<MedicalRecordResponseDTO> create(MedicalRecordCreateDTO dto) {
        final var medicalRecord = mapper.fromCreate(dto);
        Patient patient = patientService.findPatientByIdNative(dto.patientID());
        medicalRecord.setPatient(patient);
        final var newMedicalRecord = repository.save(medicalRecord);
        return Response.ok(mapper.toDTO(newMedicalRecord));
    }

    @Override
    public Response<MedicalRecordResponseDTO> update(MedicalRecordUpdateDTO dto) {
        final var medicalRecord = mapper.fromUpdate(dto);
        final var newMedicalRecord = repository.save(medicalRecord);
        return Response.ok(mapper.toDTO(newMedicalRecord));
    }

    @Override
    public Response<Boolean> delete(Long id) {
        repository.softDelete(id);
        return Response.ok(true);
    }

    @Override
    public Response<MedicalRecordResponseDTO> find(Long id) {
        return Response.ok(mapper.toDTO(repository.findByIdCustom(id).orElseThrow(
                () -> new ResourceNotFoundException("Medical record not found with id: {0}", id)
        )));
    }

    @Override
    public Response<List<MedicalRecordResponseDTO>> findAll() {
        return Response.ok(repository.findAllCustom().stream()
                .map(mapper::toDTO)
                .toList());
    }
}
