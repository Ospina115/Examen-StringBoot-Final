package com.example.proyect.demo.infrastructure.repositories.ordentrabajo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyect.demo.application.services.IOrdenTrabajoService;
import com.example.proyect.demo.domain.entities.OrdenTrabajo;

import org.springframework.transaction.annotation.Transactional;

@Service
public class OrdenTrabajoImpl implements IOrdenTrabajoService{

    @Autowired
    private OrdenTrabajoRepository ordenTrabajoRepository;

    @Transactional(readOnly = true)
    @Override
    public List<OrdenTrabajo> findAll() {
        return (List<OrdenTrabajo>)ordenTrabajoRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<OrdenTrabajo> findById(int id) {
        return ordenTrabajoRepository.findById(id);
    }

    @Transactional
    @Override
    public OrdenTrabajo save(OrdenTrabajo ordenTrabajo) {
        return ordenTrabajoRepository.save(ordenTrabajo);
    }

    @Transactional
    @Override
    public Optional<OrdenTrabajo> update(int id, OrdenTrabajo ordenTrabajo) {
        Optional<OrdenTrabajo> ordenTrabajoOld = ordenTrabajoRepository.findById(id);
        if (ordenTrabajoOld.isPresent()) {
            OrdenTrabajo ordenTrabajoDb = ordenTrabajoOld.orElseThrow();

            ordenTrabajoDb.setNumOrdenTrabajo(ordenTrabajo.getNumOrdenTrabajo());
            ordenTrabajoDb.setFechaAsignacion(ordenTrabajo.getFechaAsignacion());
            ordenTrabajoDb.setHoraAsignacion(ordenTrabajo.getHoraAsignacion());
            ordenTrabajoDb.setPersona(ordenTrabajo.getPersona());
            ordenTrabajoDb.setNumOrden(ordenTrabajo.getNumOrden());
            ordenTrabajoDb.setOrdenServicio(ordenTrabajo.getOrdenServicio());

            return Optional.of(ordenTrabajoRepository.save(ordenTrabajo));
        }
        return Optional.empty();
    }

    @Transactional
    @Override
    public Optional<OrdenTrabajo> delete(int id) {
        Optional<OrdenTrabajo> ordenTrabajoOptional = ordenTrabajoRepository.findById(id);
        ordenTrabajoOptional.ifPresent(ordenTrabajoDb -> {
            ordenTrabajoRepository.delete(ordenTrabajoDb);
        });
        return ordenTrabajoOptional;
    }
}
