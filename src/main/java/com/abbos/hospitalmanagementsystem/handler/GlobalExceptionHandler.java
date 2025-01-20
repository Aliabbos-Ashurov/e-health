package com.abbos.hospitalmanagementsystem.handler;

import com.abbos.hospitalmanagementsystem.dto.ErrorResponse;
import com.abbos.hospitalmanagementsystem.dto.Response;
import com.abbos.hospitalmanagementsystem.exception.BaseException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Aliabbos Ashurov
 * @since 14/January/2025  15:22
 **/
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<Response<ErrorResponse>> handleCryptoOperationException(BaseException ex, HttpServletRequest request) {
        var errorResponse = ErrorResponse.of(ex.getCode(), ex.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(Response.error(
                ex.getHttpStatus().value(),
                errorResponse
        ), ex.getHttpStatus());
    }
}
