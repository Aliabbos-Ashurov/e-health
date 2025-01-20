package com.abbos.hospitalmanagementsystem.dto;

import com.abbos.hospitalmanagementsystem.dto.marker.Request;
import com.abbos.hospitalmanagementsystem.enums.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * @author Aliabbos Ashurov
 * @since 14/January/2025  11:12
 **/
public record UserCreateDTO(
        @NotBlank @NotNull String fullname,
        @NotBlank @NotNull String username,
        @NotBlank @NotNull String password,
        @NotBlank @NotNull String phone,
        @NotNull Role role
) implements Request {
}
