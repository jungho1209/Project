package com.example.project.global.exception;

import com.example.project.global.error.CustomException;
import com.example.project.global.error.ErrorCode;

public class IdNotFoundException extends CustomException {

    public static final CustomException EXCEPTION =
            new IdNotFoundException();

    private IdNotFoundException() {
        super(ErrorCode.ID_NOT_FOUND);
    }
}
