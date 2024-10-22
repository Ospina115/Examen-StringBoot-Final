package com.example.proyect.demo.application.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.proyect.demo.domain.dto.UserDto;
import com.example.proyect.demo.domain.entities.User;

@Service
public interface IUserService {
    User registrOneCustomer(UserDto newUser);

    Optional<User> findOneByUsername(String username);

    
}
