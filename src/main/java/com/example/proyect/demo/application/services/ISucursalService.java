package com.example.proyect.demo.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.proyect.demo.domain.entities.Sucursal;

@Service
public interface ISucursalService {
    List<Sucursal> findAll();

    Optional<Sucursal> findById(int id);

    Sucursal save(Sucursal sucursal);

    Optional<Sucursal> update(int id, Sucursal sucursal);

    Optional<Sucursal> delete(int id);
}
