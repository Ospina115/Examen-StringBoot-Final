package com.example.proyect.demo.infrastructure.repositories.detalleorden;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.proyect.demo.application.services.IDetalleOrdenService;
import com.example.proyect.demo.domain.entities.DetalleOrden;

@Service
public class DetalleOrdenImpl implements IDetalleOrdenService{

    @Autowired 
    private DetalleOrdenRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<DetalleOrden> findAll() {
        return (List<DetalleOrden>) repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<DetalleOrden> findById(int id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public DetalleOrden save(DetalleOrden detalleOrden) {
        return repository.save(detalleOrden);
    }

    @Transactional
    @Override
    public Optional<DetalleOrden> update(int id, DetalleOrden detalleOrden) {
        Optional<DetalleOrden> detalleOrdenOptional = repository.findById(id);
        if (detalleOrdenOptional.isPresent()) {
            DetalleOrden detalleOrdenDb = detalleOrdenOptional.orElseThrow();
            detalleOrdenDb.setOrdenServicio(detalleOrden.getOrdenServicio());
            detalleOrdenDb.setServicio(detalleOrden.getServicio());
            detalleOrdenDb.setServicio(detalleOrden.getServicio());
            return Optional.of(repository.save(detalleOrdenDb));
        }
        return detalleOrdenOptional;
    }

    @Transactional
    @Override
    public Optional<DetalleOrden> delete(int id) {
        Optional<DetalleOrden> detalleOrdenOptional = repository.findById(id);
        detalleOrdenOptional.ifPresent(productDb -> {
            repository.delete(productDb);
        });
        return detalleOrdenOptional;
    }

}
