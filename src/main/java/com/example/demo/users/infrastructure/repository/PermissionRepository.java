package com.example.demo.users.infrastructure.repository;

import com.example.demo.users.domain.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
