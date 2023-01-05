package com.example.demo.controller.userController.dto.CreateUserDto;

import com.example.demo.shared.CheckValidity;
import lombok.Data;

@Data
public class CreateUserRequestDto implements CheckValidity {

    private String email;
    private String password;

    @Override
    public void check() {
        if(email == null || email.isEmpty()) {
            throw new RuntimeException("Name is empty");
        }
    }
}
