package com.example.project.user.service;

import com.example.project.user.domain.User;
import com.example.project.user.domain.repository.UserRepository;
import com.example.project.user.dto.request.PutRequest;
import com.example.project.user.dto.request.UserRequest;
import com.example.project.user.dto.response.UserListResponse;
import com.example.project.user.dto.response.UserListResponse.UserResponse;
import com.example.project.user.dto.response.UserSearchResponse;
import com.example.project.user.exception.AlreadyExistUserException;
import com.example.project.user.exception.NotExistAccountException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    // todo 회원가입 기능
    @Transactional
    public void signUp(UserRequest userRequest) {
        if (userRepository.findByAccountId(userRequest.getAccountId()).isPresent()) {
            throw AlreadyExistUserException.EXCEPTION;
        }

        User user = User.builder()
                .accountId(userRequest.getAccountId())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .name(userRequest.getName())
                .studentId(userRequest.getStudentId())
                .build();
        userRepository.save(user);
    }


    // todo 회원 리스트 가져오기
    @Transactional(readOnly = true)
    public UserListResponse searchAllDesc() {

        List<UserResponse> userList = userRepository.findAllByOrderByIdDesc()
                .stream()
                .map(user -> UserResponse.builder()
                        .accountId(user.getAccountId())
                        .name(user.getName())
                        .studentId(user.getStudentId())
                        .build())
                .collect(Collectors.toList());

        return new UserListResponse(userList);
    }


    // todo 회원 정보 수정하기
    @Transactional
    public void update(String accountId, PutRequest putRequest) {

        User user = userRepository.findByAccountId(accountId)
                .orElseThrow(() -> NotExistAccountException.EXCEPTION);

        user.update(passwordEncoder.encode(putRequest.getPassword()),
                putRequest.getName(),
                putRequest.getStudentId());

    }



    @Transactional
    public void delete(String accountId) {

        User user = userRepository.findByAccountId(accountId)
                .orElseThrow(() -> NotExistAccountException.EXCEPTION);

        userRepository.delete(user);
    }



    @Transactional(readOnly = true)
    public UserSearchResponse searchUser(String accountId) {

        User user = userRepository.findByAccountId(accountId)
                .orElseThrow(() -> NotExistAccountException.EXCEPTION);

        return UserSearchResponse.builder()
                .accountId(user.getAccountId())
                .name(user.getName())
                .StudentId(user.getStudentId())
                .build();
    }
}
