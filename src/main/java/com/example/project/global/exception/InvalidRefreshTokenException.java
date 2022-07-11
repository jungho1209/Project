package com.example.project.global.exception;

import com.example.project.global.error.CustomException;
import com.example.project.global.error.ErrorCode;

public class InvalidRefreshTokenException extends CustomException {

    public static final InvalidRefreshTokenException EXCEPTION =
            new InvalidRefreshTokenException();

    private InvalidRefreshTokenException() {
        super(ErrorCode.INVALID_REFRESH_TOKEN);
    }
}
