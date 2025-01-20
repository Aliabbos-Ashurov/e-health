package com.abbos.hospitalmanagementsystem.controller;

import com.abbos.brainwave_matrix_intern.dto.MedicalRecordCreateDTO;
import com.abbos.brainwave_matrix_intern.dto.MedicalRecordResponseDTO;
import com.abbos.brainwave_matrix_intern.dto.MedicalRecordUpdateDTO;
import com.abbos.brainwave_matrix_intern.dto.Response;
import com.abbos.brainwave_matrix_intern.service.MedicalRecordService;
import com.abbos.brainwave_matrix_intern.utils.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.abbos.brainwave_matrix_intern.utils.HttpMethod.*;

/**
 * @author Aliabbos Ashurov
 * @since 16/January/2025  11:25
 **/
@RestController
@RequestMapping(Constants.BASE_PATH_V1 + "/medical-record")
@RequiredArgsConstructor
public class MedicalRecordController {
    private final MedicalRecordService medicalRecordService;

    @Operation(
            method = _GET,
            summary = "Retrieve all medical records",
            responses = @ApiResponse(
                    responseCode = "200",
                    description = "Successfully fetched all medical records",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = MedicalRecordResponseDTO.class))
            )
    )
    @GetMapping("/get")
    public ResponseEntity<Response<List<MedicalRecordResponseDTO>>> getAll() {
        return ResponseEntity.ok(medicalRecordService.findAll());
    }

    @Operation(
            method = _POST,
            summary = "Create a new medical record",
            responses = @ApiResponse(
                    responseCode = "201",
                    description = "Medical record created successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = MedicalRecordResponseDTO.class))
            )
    )
    @PostMapping("/create")
    public ResponseEntity<Response<MedicalRecordResponseDTO>> create(@RequestBody MedicalRecordCreateDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(medicalRecordService.create(dto));
    }

    @Operation(
            method = _PUT,
            summary = "Update an existing medical record",
            responses = @ApiResponse(
                    responseCode = "200",
                    description = "Successfully updated the medical record",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = MedicalRecordResponseDTO.class))
            )
    )
    @PutMapping("/update")
    public ResponseEntity<Response<MedicalRecordResponseDTO>> update(@RequestBody MedicalRecordUpdateDTO dto) {
        return ResponseEntity.ok(medicalRecordService.update(dto));
    }

    @Operation(
            method = _DELETE,
            summary = "Delete a medical record",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully deleted the medical record",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Boolean.class))
                    )
            }
    )
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response<Boolean>> delete(@PathVariable Long id) {
        return ResponseEntity.ok(medicalRecordService.delete(id));
    }
}
