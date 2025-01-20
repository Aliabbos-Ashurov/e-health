package com.abbos.hospitalmanagementsystem.dto;

import com.abbos.brainwave_matrix_intern.dto.marker.Response;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Aliabbos Ashurov
 * @since 14/January/2025  13:12
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ErrorResponse(
        String code,
        String message,
        String path,
        String details,
        LocalDateTime timestamp)
        implements Response {

    public static ErrorResponse of(String code, String message, String path) {
        return new ErrorResponse(
                code,
                message,
                path,
                "Contact support for more details.",
                LocalDateTime.now()
        );
    }

    public String getTimestamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return timestamp.format(formatter);
    }
}

