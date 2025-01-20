package com.abbos.hospitalmanagementsystem.controller;

import com.abbos.brainwave_matrix_intern.dto.Response;
import com.abbos.brainwave_matrix_intern.dto.UserResponseDTO;
import com.abbos.brainwave_matrix_intern.dto.UserUpdateDTO;
import com.abbos.brainwave_matrix_intern.service.UserService;
import com.abbos.brainwave_matrix_intern.utils.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.abbos.brainwave_matrix_intern.utils.HttpMethod._GET;
import static com.abbos.brainwave_matrix_intern.utils.HttpMethod._PUT;

/**
 * @author Aliabbos Ashurov
 * @since 16/January/2025  11:08
 **/
@RestController
@RequestMapping(Constants.BASE_PATH_V1 + "/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(
            method = _GET,
            summary = "Retrieve user profile",
            responses = @ApiResponse(
                    responseCode = "200",
                    description = "Successfully fetched the user profile",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserResponseDTO.class))
            )
    )
    @GetMapping(value = "/profile/me", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<UserResponseDTO>> profile() {
        return ResponseEntity.ok(userService.findMe());
    }

    @Operation(
            method = _PUT,
            summary = "Update user password",
            responses = @ApiResponse(
                    responseCode = "200",
                    description = "Successfully updated the user password",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserResponseDTO.class))
            )
    )
    @PutMapping(value = "/update/password")
    public ResponseEntity<Response<UserResponseDTO>> updatePassword(@Valid @RequestBody UserUpdateDTO dto) {
        return ResponseEntity.ok(userService.update(dto));
    }
}
