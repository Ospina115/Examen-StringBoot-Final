package com.example.proyect.demo.application.services;

import java.util.Optional;

import com.example.proyect.demo.domain.entities.security.Role;

public interface IRoleService {
    Optional<Role> findDefaultRole();
}
