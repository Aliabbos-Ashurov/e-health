package com.abbos.hospitalmanagementsystem.controller;

import com.abbos.hospitalmanagementsystem.dto.PatientCreateDTO;
import com.abbos.hospitalmanagementsystem.dto.PatientResponseDTO;
import com.abbos.hospitalmanagementsystem.dto.PatientUpdateDTO;
import com.abbos.hospitalmanagementsystem.dto.Response;
import com.abbos.hospitalmanagementsystem.service.PatientService;
import com.abbos.hospitalmanagementsystem.utils.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.abbos.hospitalmanagementsystem.utils.HttpMethod.*;

/**
 * @author Aliabbos Ashurov
 * @since 16/January/2025  11:29
 **/
@RestController
@RequestMapping(Constants.BASE_PATH_V1 + "/patient")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;

    @Operation(
            method = _GET,
            summary = "Retrieve all patients",
            responses = @ApiResponse(
                    responseCode = "200",
                    description = "Successfully fetched all patients",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = PatientResponseDTO.class))
            )
    )
    @GetMapping("/get")
    public ResponseEntity<Response<List<PatientResponseDTO>>> getAll() {
        return ResponseEntity.ok(patientService.findAll());
    }

    @Operation(
            method = _POST,
            summary = "Create a new patient",
            responses = @ApiResponse(
                    responseCode = "201",
                    description = "Patient created successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = PatientResponseDTO.class))
            )
    )
    @PostMapping("/create")
    public ResponseEntity<Response<PatientResponseDTO>> create(@RequestBody PatientCreateDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(patientService.create(dto));
    }

    @Operation(
            method = _PUT,
            summary = "Update an existing patient",
            responses = @ApiResponse(
                    responseCode = "200",
                    description = "Successfully updated the patient",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = PatientResponseDTO.class))
            )
    )
    @PutMapping("/update")
    public ResponseEntity<Response<PatientResponseDTO>> update(@RequestBody PatientUpdateDTO dto) {
        return ResponseEntity.ok(patientService.update(dto));
    }

    @Operation(
            method = _DELETE,
            summary = "Delete a patient",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully deleted the patient",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Boolean.class))
                    )
            }
    )
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response<Boolean>> delete(@PathVariable Long id) {
        return ResponseEntity.ok(patientService.delete(id));
    }
}
