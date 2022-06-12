package com.example.project.user.controller;

import com.example.project.user.dto.request.PutRequest;
import com.example.project.user.dto.request.UserRequest;
import com.example.project.user.dto.response.UserListResponse;
import com.example.project.user.dto.response.UserSearchResponse;
import com.example.project.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService userService;


    // todo 회원 가입
    @PostMapping("/signup")
    public void signUp(@RequestBody @Valid UserRequest userRequest) {
        userService.signUp(userRequest);
    }


    // todo 회원 리스트 가져오기
    @GetMapping("/search")
    public UserListResponse searchAllDesc() {
        return userService.searchAllDesc();
    }


    // todo 회원 정보 수정하기
    @PutMapping("/{accountId}")
    public void update(@PathVariable("accountId") String accountId,
                       @RequestBody PutRequest putRequest) {
        userService.update(accountId, putRequest);
    }


    // todo 회원 삭제하기
    @DeleteMapping("/{accountId}")
    public void delete(@PathVariable("accountId") String accountId) {
        userService.delete(accountId);
    }


    // todo Id 로 회원 조회하기
    @GetMapping("/{accountId}")
    public UserSearchResponse searchUser(@PathVariable("accountId") String accountId) {
        return userService.searchUser(accountId);
    }

}
