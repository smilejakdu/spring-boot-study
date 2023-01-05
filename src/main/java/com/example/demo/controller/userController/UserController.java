package com.example.demo.controller.userController;

import com.example.demo.controller.userController.dto.CreateUserDto.CreateUserRequestDto;
import com.example.demo.controller.userController.dto.CreateUserDto.CreateUserResponseDto;
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

    @GetMapping("/findUser")
    public User getUser(@RequestParam Long id) throws ChangeSetPersister.NotFoundException {
        return userService.getUser(id);
    }
}
