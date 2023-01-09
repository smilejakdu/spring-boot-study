package com.example.demo.users.domain;

import com.example.demo.comment.domain.Comments;
import com.example.demo.shared.BaseTimeEntitiy;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User extends BaseTimeEntitiy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String email;

    private String password;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<Comments> comments = new ArrayList<>();
}
