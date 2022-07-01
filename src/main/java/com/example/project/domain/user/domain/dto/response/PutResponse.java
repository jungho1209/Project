package com.example.project.domain.user.domain.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PutResponse {


    private String password;
    private String name;
    private Long studentId;
}
