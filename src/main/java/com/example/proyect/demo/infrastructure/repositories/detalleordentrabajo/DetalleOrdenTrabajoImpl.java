package com.example.proyect.demo.infrastructure.repositories.detalleordentrabajo;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.proyect.demo.application.services.IDetalleOrdenTrabajoService;
import com.example.proyect.demo.domain.entities.DetalleOrdenTrabajo;

@Service
public class DetalleOrdenTrabajoImpl implements IDetalleOrdenTrabajoService{

    @Autowired
    private DetalleOrdenTrabajoRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<DetalleOrdenTrabajo> findAll() {
        return (List<DetalleOrdenTrabajo>) repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<DetalleOrdenTrabajo> findById(int id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public DetalleOrdenTrabajo save(DetalleOrdenTrabajo detalleOrdenTrabajo) {
        return repository.save(detalleOrdenTrabajo);
    }

    @Transactional
    @Override
    public Optional<DetalleOrdenTrabajo> update(int id, DetalleOrdenTrabajo detalleOrdenTrabajo) {
        Optional<DetalleOrdenTrabajo> detalleOrdenTrabajoOptional = repository.findById(id);
        if (detalleOrdenTrabajoOptional.isPresent()) {
            DetalleOrdenTrabajo detalleOrdenTrabajoDb = detalleOrdenTrabajoOptional.orElseThrow();
            detalleOrdenTrabajoDb.setOrdenTrabajo(detalleOrdenTrabajo.getOrdenTrabajo());
            detalleOrdenTrabajoDb.setServicio(detalleOrdenTrabajo.getServicio());
            detalleOrdenTrabajoDb.setFecha(detalleOrdenTrabajo.getFecha());
            detalleOrdenTrabajoDb.setEstadoServicioOrden(detalleOrdenTrabajo.getEstadoServicioOrden());
            detalleOrdenTrabajoDb.setOrdenServicio(detalleOrdenTrabajo.getOrdenServicio());
            return Optional.of(repository.save(detalleOrdenTrabajo));
        }
        return detalleOrdenTrabajoOptional;
    }

    @Transactional
    @Override
    public Optional<DetalleOrdenTrabajo> delete(int id) {
        Optional<DetalleOrdenTrabajo> detalleordentrabajOptional = repository.findById(id);
        detalleordentrabajOptional.ifPresent(detalleordentrabajDb -> {
            repository.delete(detalleordentrabajDb);
        });
        return detalleordentrabajOptional;
    }

}
