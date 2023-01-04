package com.example.demo.controller.CommentController;

import com.example.demo.controller.CommentController.dto.CommentRequestDto;
import com.example.demo.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/create")
    CommentRequestDto createComment(@RequestBody CommentRequestDto request) {
        return commentService.createComment(request);
    }
}
