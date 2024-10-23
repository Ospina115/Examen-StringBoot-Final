package com.example.proyect.demo.infrastructure.repositories.role;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyect.demo.domain.entities.security.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String defaultRole);
}
