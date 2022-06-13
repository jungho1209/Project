package com.example.project.user.service;

import com.example.project.user.domain.User;
import com.example.project.user.domain.repository.UserRepository;
import com.example.project.user.dto.request.LoginRequest;
import com.example.project.user.exception.IdNotFoundException;
import com.example.project.user.exception.PasswordMissMatchException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class LoginService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void logIn(LoginRequest loginRequest) {
        User user = userRepository.findByAccountId(loginRequest.getAccountId())
                .orElseThrow(() -> IdNotFoundException.EXCEPTION);

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw PasswordMissMatchException.EXCEPTION;
        }

    }
}
