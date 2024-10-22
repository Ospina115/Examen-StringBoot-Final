package com.example.proyect.demo.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.proyect.demo.domain.entities.EstadoAprovacion;

@Service
public interface IEstadoAprovacionService {

    List<EstadoAprovacion> findAll();

    Optional<EstadoAprovacion> finById(int id);

    EstadoAprovacion save(EstadoAprovacion estadoAprovacion);
    
    Optional<EstadoAprovacion> update(int id, EstadoAprovacion estadoAprovacion);

    Optional<EstadoAprovacion> delete(int id);
}
