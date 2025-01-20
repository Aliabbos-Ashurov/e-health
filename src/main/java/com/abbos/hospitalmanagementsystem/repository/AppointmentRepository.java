package com.abbos.hospitalmanagementsystem.repository;

import com.abbos.hospitalmanagementsystem.entity.Appointment;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * @author Aliabbos Ashurov
 * @since 14/January/2025  13:04
 **/
public interface AppointmentRepository extends JpaRepository<Appointment, Long>, Repository {

    @Query("SELECT a FROM Appointment a WHERE a.deleted = FALSE")
    List<Appointment> findAllCustom();

    @Query("SELECT a FROM Appointment a WHERE a.id = ?1 AND a.deleted = FALSE")
    Optional<Appointment> findByIdCustom(@NotNull Long id);

    @Query("SELECT a FROM Appointment a WHERE a.patient.id = ?1 AND a.deleted = FALSE")
    List<Appointment> findAllByPatientId(@NotNull Long id);

    @Query("SELECT a FROM Appointment a WHERE a.staff.id = ?1 AND a.deleted = FALSE")
    List<Appointment> findAllByStaffId(@NotNull Long id);

    @Modifying
    @Query("UPDATE Appointment a SET a.deleted = TRUE WHERE a.id = ?1")
    void softDelete(@NotNull Long id);
}
