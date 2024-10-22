package com.example.proyect.demo.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.proyect.demo.domain.entities.Servicio;

@Service
public interface IServicioService {

    List<Servicio> findAll();

    Optional<Servicio> findById(int id);

    Servicio save (Servicio servicio);

    Optional<Servicio> update(int id, Servicio servicio);

    Optional<Servicio> delete(int id);
}
