package com.example.demo.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String email;

    @OneToMany(mappedBy = "comment")
    private List<Comment> comments = new ArrayList<>();
}
