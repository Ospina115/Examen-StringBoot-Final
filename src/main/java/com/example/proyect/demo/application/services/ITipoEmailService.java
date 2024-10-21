package com.example.proyect.demo.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.proyect.demo.domain.entities.TipoEmail;

@Service
public interface ITipoEmailService {
    List<TipoEmail> findAll();

    Optional<TipoEmail> findById(int id);

    TipoEmail save(TipoEmail tipoEmail);

    Optional<TipoEmail> update(int id, TipoEmail tipoEmail);

    Optional<TipoEmail> delete(int id);
}
