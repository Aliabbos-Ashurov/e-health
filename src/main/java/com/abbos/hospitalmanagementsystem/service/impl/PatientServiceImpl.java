package com.abbos.hospitalmanagementsystem.service.impl;

import com.abbos.hospitalmanagementsystem.dto.PatientCreateDTO;
import com.abbos.hospitalmanagementsystem.dto.PatientResponseDTO;
import com.abbos.hospitalmanagementsystem.dto.PatientUpdateDTO;
import com.abbos.hospitalmanagementsystem.dto.Response;
import com.abbos.hospitalmanagementsystem.entity.Patient;
import com.abbos.hospitalmanagementsystem.enums.Gender;
import com.abbos.hospitalmanagementsystem.exception.ResourceNotFoundException;
import com.abbos.hospitalmanagementsystem.mapper.AppointmentMapper;
import com.abbos.hospitalmanagementsystem.mapper.MedicalRecordMapper;
import com.abbos.hospitalmanagementsystem.mapper.PatientMapper;
import com.abbos.hospitalmanagementsystem.repository.PatientRepository;
import com.abbos.hospitalmanagementsystem.service.AbstractService;
import com.abbos.hospitalmanagementsystem.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 14/January/2025  15:31
 **/
@Service
public class PatientServiceImpl
        extends AbstractService<PatientRepository, PatientMapper> implements PatientService {

    private final AppointmentMapper appointmentMapper;
    private final MedicalRecordMapper medicalRecordMapper;

    public PatientServiceImpl(PatientRepository repository, PatientMapper mapper, AppointmentMapper appointmentMapper, MedicalRecordMapper medicalRecordMapper) {
        super(repository, mapper);
        this.appointmentMapper = appointmentMapper;
        this.medicalRecordMapper = medicalRecordMapper;
    }

    @Override
    public Patient findPatientByIdNative(Long id) {
        return repository.findByIdCustom(id).orElseThrow(() -> new ResourceNotFoundException("Patient not found"));
    }

    @Override
    public Response<PatientResponseDTO> findByName(String firstName, String lastName) {
        return Response.ok(mapper.toDTO(repository.findByName(firstName, lastName)));
    }

    @Override
    public Response<PatientResponseDTO> findByPhoneNumber(String phoneNumber) {
        return Response.ok(mapper.toDTO(repository.findByPhoneNumber(phoneNumber)));
    }

    @Override
    public Response<List<PatientResponseDTO>> findAllByGender(Gender gender) {
        return Response.ok(repository.findAllByGender(gender).stream()
                .map(mapper::toDTO)
                .toList());
    }

    @Override
    public Response<PatientResponseDTO> create(PatientCreateDTO dto) {
        final var patient = mapper.fromCreate(dto);
        final var newPatient = repository.save(patient);
        return Response.ok(mapper.toDTO(newPatient));
    }

    @Override
    public Response<PatientResponseDTO> update(PatientUpdateDTO dto) {
        final var patient = mapper.fromUpdate(dto);
        final var newPatient = repository.save(patient);
        return Response.ok(mapper.toDTO(newPatient));
    }

    @Override
    public Response<Boolean> delete(Long id) {
        repository.softDelete(id);
        return Response.ok(true);
    }

    @Override
    public Response<PatientResponseDTO> find(Long id) {
        return Response.ok(mapper.toDTO(repository.findByIdCustom(id).orElseThrow(
                () -> new ResourceNotFoundException("Patient not found with id: {0}", id)
        )));
    }

    @Override
    public Response<List<PatientResponseDTO>> findAll() {
        return Response.ok(repository.findAllCustom().stream()
                .map(patient -> mapper.toDtoWithData(patient,
                        patient.getAppointments().stream().map(appointmentMapper::toDTO).toList(),
                        patient.getMedicalRecords().stream().map(medicalRecordMapper::toDTO).toList()))
                .toList());

    }
}
