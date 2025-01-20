package com.abbos.hospitalmanagementsystem.service.impl;

import com.abbos.hospitalmanagementsystem.dto.MedicalRecordCreateDTO;
import com.abbos.hospitalmanagementsystem.dto.MedicalRecordResponseDTO;
import com.abbos.hospitalmanagementsystem.dto.MedicalRecordUpdateDTO;
import com.abbos.hospitalmanagementsystem.dto.Response;
import com.abbos.hospitalmanagementsystem.entity.Patient;
import com.abbos.hospitalmanagementsystem.exception.ResourceNotFoundException;
import com.abbos.hospitalmanagementsystem.mapper.MedicalRecordMapper;
import com.abbos.hospitalmanagementsystem.repository.MedicalRecordRepository;
import com.abbos.hospitalmanagementsystem.service.AbstractService;
import com.abbos.hospitalmanagementsystem.service.MedicalRecordService;
import com.abbos.hospitalmanagementsystem.service.PatientService;
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
