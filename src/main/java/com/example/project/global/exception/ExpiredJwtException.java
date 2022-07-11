package com.example.project.global.exception;

import com.example.project.global.error.CustomException;
import com.example.project.global.error.ErrorCode;

public class ExpiredJwtException extends CustomException {

    public static final ExpiredJwtException EXCEPTION =
            new ExpiredJwtException();

    private ExpiredJwtException(){
        super(ErrorCode.EXPIRED_JWT);
    }
}
