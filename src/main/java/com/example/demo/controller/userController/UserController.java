package com.example.demo.controller.userController;

import com.example.demo.controller.userController.dto.CreateUserDto.CreateUserRequestDto;
import com.example.demo.controller.userController.dto.CreateUserDto.CreateUserResponseDto;
import com.example.demo.controller.userController.dto.LoginUserDto.LoginUserRequestDto;
import com.example.demo.controller.userController.dto.LoginUserDto.LoginUserResponseDto;
import com.example.demo.entities.User;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/create")
    public CreateUserResponseDto createUser(@RequestBody CreateUserRequestDto request) {
        return userService.createUser(request);
    }

    @PostMapping("/signup")
    public CreateUserResponseDto signup(@RequestBody CreateUserRequestDto request) {
        return userService.createUser(request);
    }

    @PostMapping("/login")
    public LoginUserResponseDto login(@RequestBody LoginUserRequestDto request) throws ChangeSetPersister.NotFoundException {
        return userService.login(request);
    }

    @GetMapping("/findUser")
    public User getUser(@RequestParam Long id) throws ChangeSetPersister.NotFoundException {
        return userService.getUser(id);
    }
}
