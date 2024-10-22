package com.example.proyect.demo.infrastructure.repositories.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.proyect.demo.application.services.IServicioService;
import com.example.proyect.demo.domain.entities.Servicio;

@Service
public class ServicioImpl implements IServicioService{

    @Autowired
    private ServicioRepository servicioRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Servicio> findAll() {
        return (List<Servicio>) servicioRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Servicio> findById(int id) {
        return servicioRepository.findById(id);
    }

    @Transactional
    @Override
    public Servicio save(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    @Transactional
    @Override
    public Optional<Servicio> update(int id, Servicio servicio) {
        Optional<Servicio> servicioOptional = servicioRepository.findById(id);
        if (servicioOptional.isPresent()) {
            Servicio servicioDb = servicioOptional.orElseThrow();
            servicioDb.setNombre(servicio.getNombre());
            servicioDb.setRequiereInsumo(servicio.isRequiereInsumo());
            return Optional.of(servicioRepository.save(servicioDb));
        }
        return servicioOptional;
    }

    @Transactional
    @Override
    public Optional<Servicio> delete(int id) {
        Optional<Servicio> servicioOptional = servicioRepository.findById(id);
        servicioOptional.ifPresent(servicioDb -> {
            servicioRepository.delete(servicioDb);
        });
        return servicioOptional;
    }

    
}
