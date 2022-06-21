package com.example.project.user.controller;

import com.example.project.user.domain.dto.request.PutRequest;
import com.example.project.user.domain.dto.request.UserRequest;
import com.example.project.user.domain.dto.response.UserListResponse;
import com.example.project.user.domain.dto.response.UserSearchResponse;
import com.example.project.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService userService;


    // todo 회원 가입
    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void signUp(@RequestBody @Valid UserRequest userRequest) {
        userService.signUp(userRequest);
    }


    // todo 회원 리스트 가져오기
    @GetMapping("/search")
    public UserListResponse searchAllDesc() {
        return userService.searchAllDesc();
    }


    // todo 회원 정보 수정하기
    @PutMapping("/{account-id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void update(@PathVariable("account-id") String accountId,
                       @RequestBody PutRequest putRequest) {
        userService.update(accountId, putRequest);
    }


    // todo 회원 삭제하기
    @DeleteMapping("/{account-id}")
    public void delete(@PathVariable("account-id") String accountId) {
        userService.delete(accountId);
    }


    // todo Id 로 회원 조회하기
    @GetMapping("/{account-id}")
    public UserSearchResponse searchUser(@PathVariable("account-id") String accountId) {
        return userService.searchUser(accountId);
    }

}
