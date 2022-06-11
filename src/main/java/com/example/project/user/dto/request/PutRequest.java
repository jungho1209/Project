package com.example.project.user.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PutRequest {

    private String password;
    private String name;
    private Long studentId;

}
