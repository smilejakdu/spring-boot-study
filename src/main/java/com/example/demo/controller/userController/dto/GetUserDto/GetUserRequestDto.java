package com.example.demo.controller.userController.dto.GetUserDto;

import com.example.demo.shared.CheckValidity;
import lombok.Data;

@Data
public class GetUserRequestDto implements CheckValidity {

    private String name;

    @Override
    public void check() {
        if(name == null || name.isEmpty()) {
            throw new RuntimeException("Name is empty");
        }
    }
}
