package com.example.demo.users.infrastructure.dto.GetUserDto;

import com.example.demo.users.domain.User;
import lombok.Data;

@Data
public class GetUserResponseDto {
    private User user;
}
