package com.example.demo.service;

import com.example.demo.controller.CommentController.dto.CommentRequestDto;
import com.example.demo.entities.Comment;
import com.example.demo.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    @Transactional
    public CommentRequestDto createComment(CommentRequestDto request) {
        Comment comment = new Comment();
        comment.setComment(request.getComment());
        Comment saved = commentRepository.save(comment);

        CommentRequestDto dto = new CommentRequestDto();
        dto.setId(saved.getId());
        dto.setComment(saved.getComment());

        return dto;
    }
}