package com.example.project.global.exception;

import com.example.project.global.error.CustomException;
import com.example.project.global.error.ErrorCode;

public class NotExistAccountIdException extends CustomException {

    public static final CustomException EXCEPTION =
            new NotExistAccountIdException();

    private NotExistAccountIdException() {
        super(ErrorCode.NOT_EXIST_ACCOUNT);
    }
}
