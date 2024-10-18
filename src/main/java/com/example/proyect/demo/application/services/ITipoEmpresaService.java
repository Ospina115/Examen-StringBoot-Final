package com.example.proyect.demo.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.proyect.demo.domain.entities.TipoEmpresa;

@Service
public interface ITipoEmpresaService {
    List<TipoEmpresa> findAll();

    Optional<TipoEmpresa> findById(int id);

    TipoEmpresa save(TipoEmpresa tipoEmpresa);

    Optional<TipoEmpresa> update(int id, TipoEmpresa tipoEmpresa);

    Optional<TipoEmpresa> delete(int id);
}
