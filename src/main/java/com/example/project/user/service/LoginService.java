package com.example.project.user.service;

import com.example.project.user.dto.request.LoginRequest;
import com.example.project.user.domain.User;
import com.example.project.user.domain.repository.UserRepository;
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
    public void logIn(LoginRequest loginRequest){
        User user = userRepository.findByAccountId(loginRequest.getAccountId())
                .orElseThrow(() -> new RuntimeException("해당 Id 가 존재하지 않습니다."));

       if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new RuntimeException("해당 password 가 일치하지 않습니다.");
        }

    }
}
