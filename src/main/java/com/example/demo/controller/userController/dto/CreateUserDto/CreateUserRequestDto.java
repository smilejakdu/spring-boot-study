package com.example.demo.controller.userController.dto.CreateUserDto;

import com.example.demo.shared.CheckValidity;
import lombok.Data;

@Data
public class CreateUserRequestDto implements CheckValidity {

    private Long id;

    private String name;

    @Override
    public void check() {
        if(name == null || name.isEmpty()) {
            throw new RuntimeException("Name is empty");
        }
    }
}
