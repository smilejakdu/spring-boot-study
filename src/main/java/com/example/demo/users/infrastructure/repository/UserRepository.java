package com.example.demo.users.infrastructure.repository;

import com.example.demo.users.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
