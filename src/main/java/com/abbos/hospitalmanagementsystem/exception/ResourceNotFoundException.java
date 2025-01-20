package com.abbos.hospitalmanagementsystem.exception;

import com.abbos.brainwave_matrix_intern.utils.ErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * @author Aliabbos Ashurov
 * @since 14/January/2025  15:20
 **/
@Getter
public class ResourceNotFoundException extends BaseException {

    public ResourceNotFoundException(String message, Object... args) {
        super(HttpStatus.NOT_FOUND, ErrorCode.RESOURCE_NOT_FOUND, message, args);
    }
}

