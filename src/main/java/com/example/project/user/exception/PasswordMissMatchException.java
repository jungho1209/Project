package com.example.project.user.exception;

import com.example.project.user.error.CustomException;
import com.example.project.user.error.ErrorCode;

public class PasswordMissMatchException extends CustomException {

    public static final CustomException EXCEPTION =
            new PasswordMissMatchException();

    private PasswordMissMatchException() {
        super(ErrorCode.PASSWORD_MIS_MATCH);
    }
}
