package com.example.project.domain.user.domain.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class PutRequest {


    @NotBlank(message = "password 에는 공백이 없어야합니다.")
    @Size(min = 8, max = 60)
    private String password;

    @NotBlank(message = "name 에는 공백이 없어야합니다.")
    private String name;

    private Long studentId;

}
