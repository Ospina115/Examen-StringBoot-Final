package com.example.proyect.demo.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.proyect.demo.domain.entities.DetalleOrdenTrabajo;

@Service
public interface IDetalleOrdenTrabajoService {

    List<DetalleOrdenTrabajo> findAll();

    Optional<DetalleOrdenTrabajo> findById(int id);

    DetalleOrdenTrabajo save(DetalleOrdenTrabajo detalleOrdenTrabajo);

    Optional<DetalleOrdenTrabajo> update(int id, DetalleOrdenTrabajo detalleOrdenTrabajo);

    Optional<DetalleOrdenTrabajo> delete(int id);
}
