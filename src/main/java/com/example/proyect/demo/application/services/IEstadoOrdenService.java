package com.example.proyect.demo.application.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import java.util.List;

import com.example.proyect.demo.domain.entities.EstadoOrden;

@Service
public interface IEstadoOrdenService {
    List<EstadoOrden> findAll();

    Optional<EstadoOrden> findById(int id);

    EstadoOrden save(EstadoOrden estadoOrden);

    Optional<EstadoOrden> update(int id, EstadoOrden estadoOrden);

    Optional<EstadoOrden> delete(int id);
}
