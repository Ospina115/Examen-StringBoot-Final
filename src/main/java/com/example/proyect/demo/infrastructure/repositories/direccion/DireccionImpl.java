package com.example.proyect.demo.infrastructure.repositories.direccion;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.proyect.demo.application.services.IDireccionService;
import com.example.proyect.demo.domain.entities.Direccion;

@Service
public class DireccionImpl implements IDireccionService{
    @Autowired
    private DireccionRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<Direccion> findAll() {
        return (List<Direccion>) repository.findAll();
    }

    @Override
    public Optional<Direccion> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public Direccion save(Direccion direccion) {
        return repository.save(direccion);
    }

    @Override
    public Optional<Direccion> update(int id, Direccion direccion) {
        Optional<Direccion> direccionOptional = repository.findById(id);
        if (direccionOptional.isPresent()) {
            Direccion direccionDb = direccionOptional.orElseThrow();
            direccionDb.setCalle(direccion.getCalle());
            direccionDb.setCarrera(direccion.getCarrera());
            direccionDb.setDescripcion(direccion.getDescripcion());
            direccionDb.setCiudad(direccion.getCiudad());
            return Optional.of(repository.save(direccionDb));
        }
        return direccionOptional;
    }

    @Override
    public Optional<Direccion> delete(int id) {
        Optional<Direccion> productoOptional = repository.findById(id);
        productoOptional.ifPresent(productDb -> {
            repository.delete(productDb);
        });
        return productoOptional;
    }
}
