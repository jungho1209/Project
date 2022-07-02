package com.example.project.global.exception;

import com.example.project.global.error.CustomException;
import com.example.project.global.error.ErrorCode;

public class SignatureJwtException extends CustomException {

    public static final CustomException EXCEPTION =
            new SignatureJwtException();

    private SignatureJwtException(){
        super(ErrorCode.SIGNATURE_JWT);
    }
}
