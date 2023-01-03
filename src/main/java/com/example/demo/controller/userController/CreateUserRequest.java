package com.example.demo.controller.userController;

import lombok.Data;

@Data
public class CreateUserRequest implements CheckValidity {
    private String name;

    @Override
    public void check() {
        if(name == null || name.isEmpty()) {
            throw new RuntimeException("Name is empty");
        }
    }
}
