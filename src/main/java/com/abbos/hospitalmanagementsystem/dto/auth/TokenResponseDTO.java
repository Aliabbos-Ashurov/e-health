package com.abbos.hospitalmanagementsystem.dto.auth;

import com.abbos.hospitalmanagementsystem.dto.marker.Response;
import com.abbos.hospitalmanagementsystem.enums.TokenType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

/**
 * @author Aliabbos Ashurov
 * @since 16/January/2025  11:01
 **/
@Validated
@JsonPropertyOrder({"user_id", "token_type", "access", "refresh", "_links"})
public record TokenResponseDTO(
        @JsonProperty("token_type")
        @NotNull TokenType tokenType,
        @JsonProperty("user_id")
        @NotNull Long userId,
        @NotNull TokenDTO access,
        @NotNull TokenDTO refresh
) implements Response {
    public static TokenResponseDTO of(Long userId, TokenDTO access, TokenDTO refresh) {
        return new TokenResponseDTO(TokenType.BEARER, userId, access, refresh);
    }
}

