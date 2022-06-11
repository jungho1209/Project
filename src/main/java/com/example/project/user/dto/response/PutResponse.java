package com.example.project.user.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PutResponse {


    private String password;
    private String name;
    private Long studentId;
}
