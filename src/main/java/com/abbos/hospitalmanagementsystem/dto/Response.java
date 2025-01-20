package com.abbos.hospitalmanagementsystem.dto;

import com.abbos.hospitalmanagementsystem.dto.marker.DTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * @author Aliabbos Ashurov
 * @since 14/January/2025  13:09
 **/
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<E> implements DTO {

    private boolean success;
    private int status;
    private E data;
    private String message;
    private ErrorResponse error;

    public static <E> Response<E> ok(E data) {
        return new Response<>(true, 200, data, null, null);
    }

    public static <E> Response<E> ok(int status, E data) {
        return new Response<>(true, status, data, null, null);
    }

    public static <E> Response<E> ok(HttpStatus httpStatus, E data) {
        return new Response<>(true, httpStatus.value(), data, null, null);
    }

    public static <E> Response<E> error(int status, ErrorResponse error) {
        return new Response<>(false, status, null, null, error);
    }

    public static <E> Response<E> error(HttpStatus status, ErrorResponse error) {
        return new Response<>(false, status.value(), null, null, error);
    }

    private Response(boolean success, int status, E data, String message, ErrorResponse error) {
        this.success = success;
        this.status = status;
        this.data = data;
        this.message = message;
        this.error = error;
    }
}

