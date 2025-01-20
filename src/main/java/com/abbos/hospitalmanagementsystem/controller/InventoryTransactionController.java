package com.abbos.hospitalmanagementsystem.controller;

import com.abbos.hospitalmanagementsystem.dto.InventoryTransactionCreateDTO;
import com.abbos.hospitalmanagementsystem.dto.InventoryTransactionResponseDTO;
import com.abbos.hospitalmanagementsystem.dto.InventoryTransactionUpdateDTO;
import com.abbos.hospitalmanagementsystem.dto.Response;
import com.abbos.hospitalmanagementsystem.service.InventoryTransactionService;
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
 * @since 16/January/2025  11:23
 **/
@RestController
@RequestMapping(Constants.BASE_PATH_V1 + "/i-transaction")
@RequiredArgsConstructor
public class InventoryTransactionController {
    private final InventoryTransactionService inventoryTransactionService;

    @Operation(
            method = _GET,
            summary = "Retrieve all inventory transactions",
            responses = @ApiResponse(
                    responseCode = "200",
                    description = "Successfully fetched all inventory transactions",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = InventoryTransactionResponseDTO.class))
            )
    )
    @GetMapping("/get")
    public ResponseEntity<Response<List<InventoryTransactionResponseDTO>>> getAll() {
        return ResponseEntity.ok(inventoryTransactionService.findAll());
    }

    @Operation(
            method = _POST,
            summary = "Create a new inventory transaction",
            responses = @ApiResponse(
                    responseCode = "201",
                    description = "Inventory transaction created successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = InventoryTransactionResponseDTO.class))
            )
    )
    @PostMapping("/create")
    public ResponseEntity<Response<InventoryTransactionResponseDTO>> create(@RequestBody InventoryTransactionCreateDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(inventoryTransactionService.create(dto));
    }

    @Operation(
            method = _PUT,
            summary = "Update an existing inventory transaction",
            responses = @ApiResponse(
                    responseCode = "200",
                    description = "Successfully updated the inventory transaction",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = InventoryTransactionResponseDTO.class))
            )
    )
    @PutMapping("/update")
    public ResponseEntity<Response<InventoryTransactionResponseDTO>> update(@RequestBody InventoryTransactionUpdateDTO dto) {
        return ResponseEntity.ok(inventoryTransactionService.update(dto));
    }

    @Operation(
            method = _DELETE,
            summary = "Delete an inventory transaction",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully deleted the inventory transaction",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Boolean.class))
                    )
            }
    )
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response<Boolean>> delete(@PathVariable Long id) {
        return ResponseEntity.ok(inventoryTransactionService.delete(id));
    }
}
