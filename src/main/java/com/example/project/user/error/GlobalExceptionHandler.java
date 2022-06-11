package com.example.project.user.error;

import com.example.project.user.error.ErrorResponse.BindErrorResponse;
import com.example.project.user.error.ErrorResponse.CustomErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;


@RestControllerAdvice // todo 컨트롤러 전역에서 발생할 수 있는 예외를 잡아서 처리
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class) // todo 컨트롤러 어노테이션 적용된 Bean 내에서 발생하는 예외 잡아서 하나의 메소드에서 처리
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

    @ExceptionHandler(BindException.class) // todo BindException -> @valid 와 연관 검증
    public ResponseEntity<BindErrorResponse> bindExceptionHanding(BindException e) {
        List<String> errorsList = new ArrayList<>(); // error 담는 리스트
        // todo 에러를 가져와서 에러 리스트에  메세지를 얻어와서 추가 ?
        for (FieldError error : e.getFieldErrors()) { // todo error 의 길이만큼 반복하여 메세지를 추가한다
            errorsList.add(error.getDefaultMessage());
        }

        BindErrorResponse errorResponse = BindErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .messages(errorsList)
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
