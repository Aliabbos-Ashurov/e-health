package com.abbos.hospitalmanagementsystem.controller;

import com.abbos.brainwave_matrix_intern.dto.Response;
import com.abbos.brainwave_matrix_intern.dto.UserCreateDTO;
import com.abbos.brainwave_matrix_intern.dto.UserResponseDTO;
import com.abbos.brainwave_matrix_intern.dto.auth.RefreshTokenRequestDTO;
import com.abbos.brainwave_matrix_intern.dto.auth.TokenRequestDTO;
import com.abbos.brainwave_matrix_intern.dto.auth.TokenResponseDTO;
import com.abbos.brainwave_matrix_intern.service.UserService;
import com.abbos.brainwave_matrix_intern.service.token.TokenService;
import com.abbos.brainwave_matrix_intern.utils.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.abbos.brainwave_matrix_intern.utils.HttpMethod._POST;

/**
 * @author Aliabbos Ashurov
 * @since 16/January/2025  10:55
 **/
@RestController
@RequestMapping(Constants.BASE_PATH_V1 + "/auth")
@RequiredArgsConstructor
public class AuthController {
    private final TokenService tokenService;
    private final UserService userService;

    @Operation(method = _POST,
            summary = "to get token through username & password",
            responses = @ApiResponse(
                    responseCode = "200/201",
                    description = "success",
                    content = @Content(mediaType = "application/json")))
    @PostMapping(value = "/token")
    public ResponseEntity<Response<TokenResponseDTO>> login(@Valid @RequestBody TokenRequestDTO dto) {
        return ResponseEntity.ok(tokenService.generateToken(dto.username(), dto.password()));
    }

    @Operation(
            method = _POST,
            summary = "user can refresh token through refresh tokens",
            responses = @ApiResponse(
                    responseCode = "401",
                    description = "if jwt expired",
                    content = @Content(mediaType = "application/json")))
    @PostMapping(value = "/refresh-token")
    public ResponseEntity<Response<TokenResponseDTO>> refreshToken(@Valid @RequestBody RefreshTokenRequestDTO dto) {
        return ResponseEntity.ok(tokenService.refreshToken(dto.refreshToken()));
    }

    @Operation(
            method = _POST,
            summary = "the way of getting first token",
            responses = @ApiResponse(
                    responseCode = "404",
                    description = "if user has not registered from otp yet"
            ))
    @PostMapping(value = "/register")
    private ResponseEntity<Response<UserResponseDTO>> register(@Valid @RequestBody UserCreateDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(dto));
    }
}
