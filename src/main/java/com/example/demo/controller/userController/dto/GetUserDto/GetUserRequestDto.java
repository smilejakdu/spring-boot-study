package com.example.demo.controller.userController.dto.GetUserDto;

import com.example.demo.shared.CheckValidity;
import lombok.Data;

@Data
public class GetUserRequestDto implements CheckValidity {

    private String email;

    @Override
    public void check() {
        if(email == null || email.isEmpty()) {
            throw new RuntimeException("Email is empty");
        }
    }
}
