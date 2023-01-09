package com.example.demo.comment.infrastructure.repository;

import com.example.demo.comment.domain.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comments, Long> {
}
