package com.example.proyect.demo.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.proyect.demo.domain.entities.AprovacionServicio;

@Service
public interface IAprovacionServicioService {

    List<AprovacionServicio> findAll();

    Optional<AprovacionServicio> findById(int id);

    AprovacionServicio save(AprovacionServicio aprovacionServicio);

    Optional<AprovacionServicio> update(int id, AprovacionServicio aprovacionServicio);

    Optional<AprovacionServicio> delete(int id);
}
