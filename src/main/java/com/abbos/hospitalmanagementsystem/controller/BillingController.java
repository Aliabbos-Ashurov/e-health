package com.abbos.hospitalmanagementsystem.controller;

import com.abbos.hospitalmanagementsystem.dto.BillingCreateDTO;
import com.abbos.hospitalmanagementsystem.dto.BillingResponseDTO;
import com.abbos.hospitalmanagementsystem.dto.BillingUpdateDTO;
import com.abbos.hospitalmanagementsystem.dto.Response;
import com.abbos.hospitalmanagementsystem.service.BillingService;
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
 * @since 16/January/2025  11:17
 **/
@RestController
@RequestMapping(Constants.BASE_PATH_V1 + "/billing")
@RequiredArgsConstructor
public class BillingController {
    private final BillingService billingService;

    @Operation(
            method = _GET,
            summary = "Retrieve all billing records",
            responses = @ApiResponse(
                    responseCode = "200",
                    description = "Successfully fetched all billing records",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = BillingResponseDTO.class))
            )
    )
    @GetMapping("/get")
    public ResponseEntity<Response<List<BillingResponseDTO>>> getAll() {
        return ResponseEntity.ok(billingService.findAll());
    }

    @Operation(
            method = _POST,
            summary = "Create a new billing record",
            responses = @ApiResponse(
                    responseCode = "201",
                    description = "Billing record created successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = BillingResponseDTO.class))
            )
    )
    @PostMapping("/create")
    public ResponseEntity<Response<BillingResponseDTO>> create(@RequestBody BillingCreateDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(billingService.create(dto));
    }

    @Operation(
            method = _PUT,
            summary = "Update an existing billing record",
            responses = @ApiResponse(
                    responseCode = "200",
                    description = "Successfully updated the billing record",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = BillingResponseDTO.class))
            )
    )
    @PutMapping("/update")
    public ResponseEntity<Response<BillingResponseDTO>> update(@RequestBody BillingUpdateDTO dto) {
        return ResponseEntity.ok(billingService.update(dto));
    }

    @Operation(
            method = _DELETE,
            summary = "Delete a billing record",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully deleted the billing record",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Boolean.class))
                    )
            }
    )
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response<Boolean>> delete(@PathVariable Long id) {
        return ResponseEntity.ok(billingService.delete(id));
    }
}
