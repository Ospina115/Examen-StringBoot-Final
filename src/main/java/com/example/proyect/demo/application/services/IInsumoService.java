package com.example.proyect.demo.application.services;

import java.util.Optional;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.proyect.demo.domain.entities.Insumo;

@Service
public interface IInsumoService {

    List<Insumo> findAll();

    Optional<Insumo> findById(int id);

    Insumo save(Insumo insumo);

    Optional<Insumo> update(int id, Insumo insumo);

    Optional<Insumo> delete(int id);
}
