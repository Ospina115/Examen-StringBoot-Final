package com.example.proyect.demo.application.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.example.proyect.demo.domain.entities.TipoPersona;


@Service
public interface ITipoPersonaService {

    List<TipoPersona> findAll();

    Optional<TipoPersona> findById(int id);

    TipoPersona save(TipoPersona tipoPersona);

    Optional<TipoPersona> update(int id, TipoPersona tipoPersona);

    Optional<TipoPersona> delete(int id);
}
