package com.example.project.global.exception;

import com.example.project.global.error.CustomException;
import com.example.project.global.error.ErrorCode;

public class AuthNotFoundException extends CustomException {

    public static final AuthNotFoundException EXCEPTION =
            new AuthNotFoundException();

    private AuthNotFoundException(){
        super(ErrorCode.AUTH_NOT_FOUND);
    }
}
