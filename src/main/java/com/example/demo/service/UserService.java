package com.example.demo.service;

import com.example.demo.controller.userController.CreateUserRequest;
import com.example.demo.controller.userController.UserDto;
import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public UserDto createUser(CreateUserRequest request) {
        User user = new User();
        user.setName(request.getName());
        User saved = userRepository.save(user);

        UserDto dto = new UserDto();
        dto.setId(saved.getId());
        dto.setName(saved.getName());

        return dto;
    }
}
