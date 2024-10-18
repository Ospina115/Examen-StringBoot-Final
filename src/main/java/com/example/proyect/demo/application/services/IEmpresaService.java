package com.example.proyect.demo.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.proyect.demo.domain.entities.Empresa;

@Service
public interface IEmpresaService {
    List<Empresa> findAll();

    Optional<Empresa> findById(int id);

    Empresa save(Empresa empresa);

    Optional<Empresa> update(int id, Empresa empresa);

    Optional<Empresa> delete(int id);
}
