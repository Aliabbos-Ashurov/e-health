package com.abbos.hospitalmanagementsystem.dto;

import com.abbos.hospitalmanagementsystem.dto.marker.Response;
import com.abbos.hospitalmanagementsystem.enums.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * @author Aliabbos Ashurov
 * @since 14/January/2025  11:09
 **/
@JsonPropertyOrder({"id", "fullname", "username", "phone", "twoFactorEnabled", "notificationsEnabled", "role"})
@Schema(description = "Response DTO representing a user, containing information about the user's profile, phone number, notification settings, and role.")
public record UserResponseDTO(
        @NotNull Long id,
        @NotBlank @NotNull String fullname,
        @NotBlank @NotNull String username,
        @NotBlank @NotNull String phone,

        @JsonProperty("two_factor_enabled")
        @NotNull Boolean twoFactorEnabled,

        @JsonProperty("notifications_enabled")
        @NotNull Boolean notificationsEnabled,
        @NotNull Role role
) implements Response {
}
