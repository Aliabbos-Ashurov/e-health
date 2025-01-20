package com.abbos.hospitalmanagementsystem.repository;

import com.abbos.brainwave_matrix_intern.entity.MedicalRecord;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * @author Aliabbos Ashurov
 * @since 14/January/2025  13:02
 **/
public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long>, Repository {

    @Query("SELECT m FROM MedicalRecord m WHERE m.deleted = FALSE")
    List<MedicalRecord> findAllCustom();

    @Query("SELECT m FROM MedicalRecord m WHERE m.id = ?1 AND m.deleted = FALSE")
    Optional<MedicalRecord> findByIdCustom(@NotNull Long id);

    @Query("SELECT m FROM MedicalRecord m WHERE m.patient.id = ?1 AND m.deleted = FALSE")
    Optional<MedicalRecord> findByPatientId(@NotNull Long id);

    @Query("SELECT m FROM MedicalRecord m WHERE m.diagnosis ILIKE %:diagnosis%")
    List<MedicalRecord> findByDiagnosis(@Param("diagnosis") String diagnosis);

    @Modifying
    @Query("UPDATE MedicalRecord m SET m.deleted = TRUE WHERE m.id = ?1")
    void softDelete(@NotNull Long id);
}
