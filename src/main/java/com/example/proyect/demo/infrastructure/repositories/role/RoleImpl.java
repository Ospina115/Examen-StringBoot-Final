package com.example.proyect.demo.infrastructure.repositories.role;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.proyect.demo.application.services.IRoleService;
import com.example.proyect.demo.domain.entities.security.Role;

@Service
public class RoleImpl implements IRoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Value("${security.default.role}")
    private String defaultRole;

    @Override
    public Optional<Role> findDefaultRole() {
        return roleRepository.findByName(defaultRole);
    }
}
