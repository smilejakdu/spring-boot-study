package com.example.demo.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 1000, name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Long user_id;

}
