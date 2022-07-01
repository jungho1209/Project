package com.example.project.domain.user.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class UserListResponse {

    private final List<UserResponse> userList;

    @Getter
    @Builder
    public static class UserResponse {
        private final String accountId;
        private final String name;
        private final Long studentId;
    }
}
