package com.example.project.user.error.ErrorResponse;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE) // todo AllArgs 랑 Builder 같이 쓰는 이유 ? 빌더 패턴은 파라미터를 1개씩 가지는 생성자가 필요한데 이를 AllArgs 가 만들어줌
@Builder

public class BindErrorResponse {  // todo BindError 는 @Valid 와 연관이 있음.

    private final int status;
    private final List<String> messages;
}
