package com.example.proyect.demo.infrastructure.repositories.estadoorden;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.example.proyect.demo.application.services.IEstadoOrdenService;
import com.example.proyect.demo.domain.entities.EstadoOrden;


@Service
public class EstadoOrdenImpl implements IEstadoOrdenService {
    @Autowired
    private EstadoOrdenRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<EstadoOrden> findAll() {
        return (List<EstadoOrden>) repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<EstadoOrden> findById(int id) {
        return repository.findById(id);
    } 

    @Transactional
    @Override
    public EstadoOrden save(EstadoOrden estadoOrden) {
        return repository.save(estadoOrden);
    }

    @Transactional
    @Override
    public Optional<EstadoOrden> update(int id, EstadoOrden estadoOrden) {
        Optional<EstadoOrden> estadoOrdenOptional = repository.findById(id);
        if (estadoOrdenOptional.isPresent()) {
            EstadoOrden estadoOrdenDb = estadoOrdenOptional.orElseThrow();
            estadoOrdenDb.setNombre(estadoOrden.getNombre());
            return Optional.of(repository.save(estadoOrdenDb));
        }
        return estadoOrdenOptional;
    }

    @Transactional
    @Override
    public Optional<EstadoOrden> delete(int id) {
        Optional<EstadoOrden> productoOptional = repository.findById(id);
        productoOptional.ifPresent(productDb -> {
            repository.delete(productDb);
        });
        return productoOptional;
    }
}
