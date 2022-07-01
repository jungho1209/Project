package com.example.project.domain.user.domain.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponse {

    private final String accountId;
    private final String password;
    private final String name;
    private final Long studentId;


}
