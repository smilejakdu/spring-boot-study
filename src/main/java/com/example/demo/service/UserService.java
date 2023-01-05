package com.example.demo.service;

import com.example.demo.controller.userController.dto.CreateUserDto.CreateUserRequestDto;
import com.example.demo.controller.userController.dto.CreateUserDto.CreateUserResponseDto;
import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public CreateUserResponseDto createUser(CreateUserRequestDto request) {
        User user = new User();
        user.setName(request.getName());
        User saved = userRepository.save(user);

        CreateUserResponseDto responseDto = new CreateUserResponseDto();
        responseDto.setId(saved.getId());
        responseDto.setName(saved.getName());

        return responseDto;
    }

    @Transactional
    public User getUser(Long id) throws ChangeSetPersister.NotFoundException {
        return userRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }
}
