package com.example.proyect.demo.application.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.proyect.demo.domain.entities.TelPersona;

import java.util.List;

@Service
public interface ITelPersonaService {
    List<TelPersona> findAll();

    Optional<TelPersona> findById(int id);

    TelPersona save(TelPersona telPersona);

    Optional<TelPersona> update(int id, TelPersona telPersona);

    Optional<TelPersona> delete(int id);
}
