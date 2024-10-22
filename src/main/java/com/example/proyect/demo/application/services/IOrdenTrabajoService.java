package com.example.proyect.demo.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.proyect.demo.domain.entities.OrdenTrabajo;

@Service
public interface IOrdenTrabajoService {

    List<OrdenTrabajo> findAll();

    Optional<OrdenTrabajo> findById(int id);

    OrdenTrabajo save(OrdenTrabajo ordenTrabajo);

    Optional<OrdenTrabajo> update(int id, OrdenTrabajo ordenTrabajo);

    Optional<OrdenTrabajo> delete(int id);
}
