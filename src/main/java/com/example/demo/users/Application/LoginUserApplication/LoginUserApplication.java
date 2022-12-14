package com.example.demo.users.Application.LoginUserApplication;

import com.example.demo.config.SecurityService;
import com.example.demo.users.domain.User;
import com.example.demo.users.infrastructure.dto.LoginUserDto.LoginUserRequestDto;
import com.example.demo.users.infrastructure.dto.LoginUserDto.LoginUserResponseDto;
import com.example.demo.users.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LoginUserApplication implements LoginUserApplicationImpl {

    private final UserRepository userRepository;
    @Transactional
    @Override
    public String login(LoginUserRequestDto request) {
        try {
            User user = userRepository.findByEmail(request.getEmail());

            if (user == null) {
                throw new RuntimeException("가입되어있지 않은 유저 입니다.");
            }

            if (BCrypt.checkpw(request.getPassword(), user.getPassword())) {
                return request.getEmail();
            } else {
                throw new RuntimeException("비밀번호가 일치하지 않습니다.");
            }
        } catch (Exception e) {
            throw new RuntimeException("bad request");
        }
    }
}
