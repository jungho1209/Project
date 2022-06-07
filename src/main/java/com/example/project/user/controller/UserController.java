package com.example.project.user.controller;

import com.example.project.user.dto.request.UserRequest;
import com.example.project.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public void signUp(@RequestBody @Valid UserRequest userRequest){
        userService.signUp(userRequest);
    }
}
