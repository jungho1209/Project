package com.example.project.user.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserSearchResponse {
    private final String accountId;
    private final String name;
    private final Long StudentId;
}
