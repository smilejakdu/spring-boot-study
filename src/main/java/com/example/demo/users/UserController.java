package com.example.demo.users;

import com.example.demo.users.Application.LoginUserApplication.LoginUserApplication;
import com.example.demo.users.Application.LoginUserApplication.LoginUserApplicationImpl;
import com.example.demo.users.infrastructure.dto.CreateUserDto.CreateUserRequestDto;
import com.example.demo.users.infrastructure.dto.CreateUserDto.CreateUserResponseDto;
import com.example.demo.users.infrastructure.dto.LoginUserDto.LoginUserRequestDto;
import com.example.demo.users.infrastructure.dto.LoginUserDto.LoginUserResponseDto;
import com.example.demo.users.domain.User;
import com.example.demo.users.Application.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final LoginUserApplication loginUserApplication;

    @PostMapping("/signup")
    public CreateUserResponseDto signup(@RequestBody CreateUserRequestDto request) {
        System.out.println("signup");
        return userService.createUser(request);
    }

    @PostMapping("/login")
    public LoginUserResponseDto login(@RequestBody LoginUserRequestDto request) {
        return loginUserApplication.login(request);
    }

    @GetMapping("/findUser")
    public User getUser(@RequestParam Long id) throws ChangeSetPersister.NotFoundException {
        return userService.getUser(id);
    }
}
