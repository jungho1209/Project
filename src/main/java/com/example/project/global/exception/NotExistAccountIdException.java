package com.example.project.user.exception;

import com.example.project.user.error.CustomException;
import com.example.project.user.error.ErrorCode;

public class NotExistAccountIdException extends CustomException {

    public static final CustomException EXCEPTION =
            new NotExistAccountIdException();

    private NotExistAccountIdException() {
        super(ErrorCode.NOT_EXIST_ACCOUNT);
    }
}
