package com.example.proyect.demo.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.proyect.demo.domain.entities.Ciudad;


@Service
public interface ICiudadService {

    List<Ciudad> findAll();

    Optional<Ciudad> findById(int id);

    Ciudad save(Ciudad ciudad);

    Optional<Ciudad> update(int id, Ciudad ciudad);

    Optional<Ciudad> delete(int id);
}
