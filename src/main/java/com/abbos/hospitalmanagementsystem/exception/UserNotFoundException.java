package com.abbos.hospitalmanagementsystem.exception;

import com.abbos.hospitalmanagementsystem.utils.ErrorCode;
import org.springframework.http.HttpStatus;

/**
 * @author Aliabbos Ashurov
 * @since 14/January/2025  15:22
 **/
public class UserNotFoundException extends BaseException {

    public UserNotFoundException(String message, Object... args) {
        super(HttpStatus.NOT_FOUND, ErrorCode.NOT_FOUND, message, args);
    }
}
