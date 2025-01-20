package com.abbos.hospitalmanagementsystem.controller;

import com.abbos.hospitalmanagementsystem.dto.AppointmentCreateDTO;
import com.abbos.hospitalmanagementsystem.dto.AppointmentResponseDTO;
import com.abbos.hospitalmanagementsystem.dto.AppointmentUpdateDTO;
import com.abbos.hospitalmanagementsystem.dto.Response;
import com.abbos.hospitalmanagementsystem.service.AppointmentService;
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
 * @since 16/January/2025  11:12
 **/
@RestController
@RequestMapping(Constants.BASE_PATH_V1 + "/appointment")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;

    @Operation(
            method = _GET,
            summary = "Retrieve all appointments",
            responses = @ApiResponse(
                    responseCode = "200",
                    description = "Successfully fetched all appointments",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = AppointmentResponseDTO.class))
            )
    )
    @GetMapping("/get")
    public ResponseEntity<Response<List<AppointmentResponseDTO>>> getAll() {
        return ResponseEntity.ok(appointmentService.findAll());
    }

    @Operation(
            method = _POST,
            summary = "Create a new appointment",
            responses = @ApiResponse(
                    responseCode = "201",
                    description = "Appointment created successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = AppointmentResponseDTO.class))
            )
    )
    @PostMapping("/create")
    public ResponseEntity<Response<AppointmentResponseDTO>> create(@RequestBody AppointmentCreateDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(appointmentService.create(dto));
    }

    @Operation(
            method = _PUT,
            summary = "Update an existing appointment",
            responses = @ApiResponse(
                    responseCode = "200",
                    description = "Successfully updated the appointment",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = AppointmentResponseDTO.class))
            )
    )
    @PutMapping("/update")
    public ResponseEntity<Response<AppointmentResponseDTO>> update(@RequestBody AppointmentUpdateDTO dto) {
        return ResponseEntity.ok(appointmentService.update(dto));
    }

    @Operation(
            method = _DELETE,
            summary = "Delete an appointment",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully deleted the appointment",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Boolean.class))
                    )
            }
    )
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response<Boolean>> deleteAppointment(@PathVariable Long id) {
        return ResponseEntity.ok(appointmentService.delete(id));
    }
}
