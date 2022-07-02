package com.example.project.global.exception;

import com.example.project.global.error.CustomException;
import com.example.project.global.error.ErrorCode;

public class InvalidJwtException extends CustomException {

    public static final CustomException EXCEPTION =
            new InvalidJwtException();

    private InvalidJwtException(){
        super(ErrorCode.INVALID_JWT);
    }
}
