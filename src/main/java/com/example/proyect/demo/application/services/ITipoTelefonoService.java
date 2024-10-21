package com.example.proyect.demo.application.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.proyect.demo.domain.entities.TipoTelefono;

import java.util.List;

@Service
public interface ITipoTelefonoService {
    List<TipoTelefono> findAll();

    Optional<TipoTelefono> findById(int id);

    TipoTelefono save(TipoTelefono tipoTelefono);

    Optional<TipoTelefono> update(int id, TipoTelefono tipoTelefono);

    Optional<TipoTelefono> delete(int id);
}
