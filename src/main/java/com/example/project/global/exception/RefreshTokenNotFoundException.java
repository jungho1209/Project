package com.example.project.global.exception;

import com.example.project.global.error.CustomException;
import com.example.project.global.error.ErrorCode;

public class RefreshTokenNotFoundException extends CustomException {

    public static final RefreshTokenNotFoundException EXCEPTION =
            new RefreshTokenNotFoundException();

    private RefreshTokenNotFoundException(){
        super(ErrorCode.REFRESH_TOKEN_NOT_FOUND);
    }
}
