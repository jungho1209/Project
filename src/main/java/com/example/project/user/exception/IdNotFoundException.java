package com.example.project.user.exception;

import com.example.project.user.error.CustomException;
import com.example.project.user.error.ErrorCode;

public class IdNotFoundException extends CustomException {

    public static final CustomException EXCEPTION =
            new IdNotFoundException();

    private IdNotFoundException() {
        super(ErrorCode.ID_NOT_FOUND);
    }
}
