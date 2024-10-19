package com.example.proyect.demo.application.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.proyect.demo.domain.entities.OrdenServicio;

@Service
public interface IOrdenServicioService {

    List<OrdenServicio> findAll();

    Optional<OrdenServicio> findById(int id);

    OrdenServicio save(OrdenServicio ordenServicio);

    Optional<OrdenServicio> update(int id, OrdenServicio ordenServicio);

    Optional<OrdenServicio> delete(int id);
}
