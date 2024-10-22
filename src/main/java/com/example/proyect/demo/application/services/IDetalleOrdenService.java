package com.example.proyect.demo.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.proyect.demo.domain.entities.DetalleOrden;


@Service
public interface IDetalleOrdenService {

    List<DetalleOrden> findAll();

    Optional<DetalleOrden> findById(int id);

    DetalleOrden save(DetalleOrden detalleOrden);

    Optional<DetalleOrden> update(int id, DetalleOrden detalleOrden);

    Optional<DetalleOrden> delete(int id);

}
