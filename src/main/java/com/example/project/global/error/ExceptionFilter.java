package com.example.project.global.error;

import com.example.project.global.error.ErrorResponse.CustomErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class ExceptionFilter extends OncePerRequestFilter {

    // todo OncePerRequestFilter 를 상속받는 이유는 -> 한 요청에 한번의 필터만 실행되게하며 , 필터로 등록하기위해 사용

    private final ObjectMapper objectMapper;
    // todo objectMapper 를 DI 하는 이유는 ErrorResponse 를 해야할 때 json 형식으로 변환해주기 위해서 사용

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws IOException { // todo OncePerRequestFilter 에 있는 거 재정의
        try { // todo 아래 에러가 발생하면 잡음
            filterChain.doFilter(request, response);
        } catch (CustomException e) {
            sendErrorMessage(response, e.getErrorcode());
        } catch (Exception e) {
            logger.error(e);
            sendErrorMessage(response, ErrorCode.INTERNAL_SERVER_ERROR);
        }
    }

    private void sendErrorMessage(HttpServletResponse response, ErrorCode errorCode) throws IOException {
        CustomErrorResponse customErrorResponse = CustomErrorResponse.builder()
                .status(errorCode.getStatus())
                .message(errorCode.getMessage())
                .build();
        String errorResponseJson = objectMapper.writeValueAsString(customErrorResponse); // todo Json 값으로 변환을 해줌

        response.setStatus(errorCode.getStatus()); // todo 응답에 상태코드 지정
        response.setContentType("application/json"); // todo Json 타입으로 지정
        response.getWriter().write(errorResponseJson); // todo 에러 Json 메세지 받게함
    }
}
