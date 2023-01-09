package com.example.demo.users.domain;

import com.example.demo.shared.BaseTimeEntitiy;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "permissions")
public class Permission extends BaseTimeEntitiy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private UserType userType;
}
