package com.example.demo.users.Application.LoginUserApplication;

import com.example.demo.users.infrastructure.dto.LoginUserDto.LoginUserRequestDto;
import com.example.demo.users.infrastructure.dto.LoginUserDto.LoginUserResponseDto;

public interface LoginUserApplicationImpl {
    LoginUserResponseDto login(LoginUserRequestDto request);
}
