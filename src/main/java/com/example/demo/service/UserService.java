package com.example.demo.service;

import com.example.demo.controller.userController.dto.CreateUserDto.CreateUserRequestDto;
import com.example.demo.controller.userController.dto.CreateUserDto.CreateUserResponseDto;
import com.example.demo.controller.userController.dto.LoginUserDto.LoginUserRequestDto;
import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public CreateUserResponseDto createUser(CreateUserRequestDto request) {
        User user = userRepository.findByEmail(request.getEmail());
        if (user != null) {
            throw new RuntimeException("이미 가입되어있는 유저 입니다.");
        }

        User newUser = new User();
        String password = request.getPassword();
        String bctrptPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        newUser.setEmail(request.getEmail());
        newUser.setPassword(bctrptPassword);
        User saved = userRepository.save(newUser);

        CreateUserResponseDto responseDto = new CreateUserResponseDto();
        responseDto.setId(saved.getId());
        responseDto.setEmail(saved.getEmail());

        return responseDto;
    }

    @Transactional
    public User login(LoginUserRequestDto request) {
        User user = userRepository.findByEmail(request.getEmail());
        if (user == null) {
            throw new RuntimeException("가입되어있지 않은 유저 입니다.");
        }

        if (BCrypt.checkpw(request.getPassword(), user.getPassword())) {
            return user;
        } else {
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }
    }

    @Transactional
    public User getUser(Long id) throws ChangeSetPersister.NotFoundException {
        return userRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }
}
