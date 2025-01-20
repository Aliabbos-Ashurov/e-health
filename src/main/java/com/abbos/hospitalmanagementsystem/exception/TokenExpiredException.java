package com.abbos.hospitalmanagementsystem.exception;

import com.abbos.hospitalmanagementsystem.utils.ErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * @author Aliabbos Ashurov
 * @since 14/January/2025  15:21
 **/
@Getter
public class TokenExpiredException extends BaseException {

    public TokenExpiredException(String message, Object... args) {
        super(HttpStatus.UNAUTHORIZED, ErrorCode.TOKEN_EXPIRED, message, args);
    }
}

