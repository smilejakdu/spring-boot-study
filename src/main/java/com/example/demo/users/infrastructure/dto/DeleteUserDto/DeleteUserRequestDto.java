package com.example.demo.users.infrastructure.dto.DeleteUserDto;

import com.example.demo.shared.CheckValidity;
import lombok.Data;

@Data
public class DeleteUserRequestDto implements CheckValidity {
    private String userId;
    @Override
    public void check() {
        if(userId == null || userId.isEmpty()) {
            throw new RuntimeException("userId is empty");
        }
    }

}
