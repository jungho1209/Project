package com.example.project.user.exception;


import com.example.project.user.error.CustomException;
import com.example.project.user.error.ErrorCode;

public class AlreadyExistUserException extends CustomException {

    public static final CustomException EXCEPTION =
            new AlreadyExistUserException(); // todo 싱글톤 패턴 -> 메모리를 한번만 할당해서 인스턴스를 만들어 사용

    // todo 인스턴스를 메모리에 등록해서 인스턴스 공유해서 사용 가능하게해서 요청 많은 곳에서 사용하면 효율 높음
    private AlreadyExistUserException() {
        super(ErrorCode.USER_EXISTS);
    }
}
