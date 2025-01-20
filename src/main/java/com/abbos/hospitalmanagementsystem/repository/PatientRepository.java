package com.abbos.hospitalmanagementsystem.repository;

import com.abbos.hospitalmanagementsystem.entity.Patient;
import com.abbos.hospitalmanagementsystem.enums.Gender;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * @author Aliabbos Ashurov
 * @since 14/January/2025  13:02
 **/
public interface PatientRepository extends JpaRepository<Patient, Long>, Repository {

    @Query("SELECT p FROM Patient p WHERE p.deleted = FALSE")
    List<Patient> findAllCustom();

    @Query("SELECT p FROM Patient p WHERE p.id = ?1 AND p.deleted = FALSE")
    Optional<Patient> findByIdCustom(@NotNull Long id);

    @Query("SELECT p FROM Patient p  WHERE p.firstName = ?1 AND p.lastName = ?2 AND p.deleted = FALSE")
    Patient findByName(@NotNull String firstName, @NotNull String lastName);

    @Query(" SELECT p FROM Patient p  WHERE p.phoneNumber = ?1 AND p.deleted = FALSE")
    Patient findByPhoneNumber(@NotNull String phoneNumber);


    @Query("SELECT p FROM Patient p  WHERE p.gender = :gender  AND p.deleted = FALSE")
    List<Patient> findAllByGender(@NotNull Gender gender);

    @Modifying
    @Query("UPDATE Patient p SET p.deleted = TRUE WHERE p.id = ?1")
    void softDelete(@NotNull Long id);
}
