package com.example.demo.comment.domain;

import com.example.demo.shared.BaseTimeEntitiy;
import com.example.demo.users.domain.User;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "comments")
public class Comments extends BaseTimeEntitiy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 1000, name = "content")
    private String content;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;
}
