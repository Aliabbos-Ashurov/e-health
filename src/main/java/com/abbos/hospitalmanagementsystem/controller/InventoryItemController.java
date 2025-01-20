package com.abbos.hospitalmanagementsystem.controller;

import com.abbos.brainwave_matrix_intern.dto.InventoryItemCreateDTO;
import com.abbos.brainwave_matrix_intern.dto.InventoryItemResponseDTO;
import com.abbos.brainwave_matrix_intern.dto.InventoryItemUpdateDTO;
import com.abbos.brainwave_matrix_intern.dto.Response;
import com.abbos.brainwave_matrix_intern.service.InventoryItemService;
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
 * @since 16/January/2025  11:21
 **/
@RestController
@RequestMapping(Constants.BASE_PATH_V1 + "/i-tem")
@RequiredArgsConstructor
public class InventoryItemController {
    private final InventoryItemService inventoryItemService;

    @Operation(
            method = _GET,
            summary = "Retrieve all inventory items",
            responses = @ApiResponse(
                    responseCode = "200",
                    description = "Successfully fetched all inventory items",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = InventoryItemResponseDTO.class))
            )
    )
    @GetMapping("/get")
    public ResponseEntity<Response<List<InventoryItemResponseDTO>>> getAll() {
        return ResponseEntity.ok(inventoryItemService.findAll());
    }

    @Operation(
            method = _POST,
            summary = "Create a new inventory item",
            responses = @ApiResponse(
                    responseCode = "201",
                    description = "Inventory item created successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = InventoryItemResponseDTO.class))
            )
    )
    @PostMapping("/create")
    public ResponseEntity<Response<InventoryItemResponseDTO>> create(@RequestBody InventoryItemCreateDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(inventoryItemService.create(dto));
    }

    @Operation(
            method = _PUT,
            summary = "Update an existing inventory item",
            responses = @ApiResponse(
                    responseCode = "200",
                    description = "Successfully updated the inventory item",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = InventoryItemResponseDTO.class))
            )
    )
    @PutMapping("/update")
    public ResponseEntity<Response<InventoryItemResponseDTO>> update(@RequestBody InventoryItemUpdateDTO dto) {
        return ResponseEntity.ok(inventoryItemService.update(dto));
    }

    @Operation(
            method = _DELETE,
            summary = "Delete an inventory item",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully deleted the inventory item",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Boolean.class))
                    )
            }
    )
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response<Boolean>> delete(@PathVariable Long id) {
        return ResponseEntity.ok(inventoryItemService.delete(id));
    }
}
