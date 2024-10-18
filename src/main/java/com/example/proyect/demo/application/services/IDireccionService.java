package com.example.proyect.demo.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.proyect.demo.domain.entities.Direccion;

@Service
public interface IDireccionService {
    List<Direccion> findAll();

    Optional<Direccion> findById(int id);

    Direccion save(Direccion direccion);

    Optional<Direccion> update(int id, Direccion direccion);

    Optional<Direccion> delete(int id);
}
