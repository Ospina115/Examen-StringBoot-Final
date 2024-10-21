package com.example.proyect.demo.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.proyect.demo.domain.entities.EmailPersona;

@Service
public interface IEmailPersonaService {
    List<EmailPersona> findAll();
    
    Optional<EmailPersona> findById(int id);

    EmailPersona save(EmailPersona emailPersona);

    Optional<EmailPersona> update(int id, EmailPersona emailPersona);

    Optional<EmailPersona> delete(int id);
}
