package com.example.project.global.exception;

import com.example.project.global.error.CustomException;
import com.example.project.global.error.ErrorCode;

public class PasswordMissMatchException extends CustomException {

    public static final CustomException EXCEPTION =
            new PasswordMissMatchException();

    private PasswordMissMatchException() {
        super(ErrorCode.PASSWORD_MIS_MATCH);
    }
}

