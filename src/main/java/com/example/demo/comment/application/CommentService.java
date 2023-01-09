package com.example.demo.comment.application;

import com.example.demo.comment.infrastructure.dto.CommentRequestDto;
import com.example.demo.comment.domain.Comments;
import com.example.demo.comment.infrastructure.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    @Transactional
    public CommentRequestDto createComment(CommentRequestDto request) {
        Comments comments = new Comments();
        comments.setContent(request.getContent());
        Comments saved = commentRepository.save(comments);

        CommentRequestDto dto = new CommentRequestDto();
        dto.setContent(saved.getContent());

        return dto;
    }
}
