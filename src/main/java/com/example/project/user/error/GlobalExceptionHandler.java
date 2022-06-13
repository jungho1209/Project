package com.example.project.user.error;

import com.example.project.user.error.ErrorResponse.CustomErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice // todo 컨트롤러 전역에서 발생할 수 있는 예외를 잡아서 처리(@RestController 어노테이션 붙은 클래스만)
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class) // todo 컨트롤러 어노테이션 적용된 Bean 내에서 발생하는 예외 잡아서 하나의 메소드에서 처리 하나의 클래스만 처리
    public ResponseEntity<CustomErrorResponse> customExceptionHandling(CustomException e) {
        final ErrorCode errorCode = e.getErrorcode();
        return new ResponseEntity<>(
                CustomErrorResponse.builder()
                        .status(errorCode.getStatus())
                        .message(errorCode.getMessage())
                        .build(),
                HttpStatus.valueOf(errorCode.getStatus()) // todo 에러 상태 코드 띄워줌
        );
    }

    @ExceptionHandler(BindException.class) // todo BindException -> @valid 와 연관
    public ResponseEntity<?> bindExceptionHanding(BindException e) {
        Map<String, String> errorsList = new HashMap<>(); // todo error 담는 리스트 key - value 형태로 저장되는 배열 : Map
        for (FieldError error : e.getFieldErrors()) { // todo error 의 길이만큼 반복하여 메세지를 추가한다
            errorsList.put(error.getField(), error.getDefaultMessage());
        }

        return new ResponseEntity<>(errorsList, HttpStatus.BAD_REQUEST);
    }
}
