package com.example.proyect.demo.infrastructure.repositories.ordenservicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyect.demo.application.services.IOrdenServicioService;
import com.example.proyect.demo.domain.entities.OrdenServicio;

import org.springframework.transaction.annotation.Transactional;


@Service
public class OrdenServicioImpl implements IOrdenServicioService{

    @Autowired
    private OrdenServicioRepository ordenServicioRepository;

    @Transactional(readOnly = true)
    @Override
    public List<OrdenServicio> findAll() {
       return (List<OrdenServicio>)ordenServicioRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<OrdenServicio> findById(int id) {
       return ordenServicioRepository.findById(id);
    }

    @Transactional
    @Override
    public OrdenServicio save(OrdenServicio ordenServicio) {
        return ordenServicioRepository.save(ordenServicio);
    }

    @Transactional
    @Override
    public Optional<OrdenServicio> update(int id, OrdenServicio ordenServicio) {
       Optional<OrdenServicio> ordenservicioOld = ordenServicioRepository.findById(id);
       if (ordenservicioOld.isPresent()) {
            OrdenServicio ordenServicioDb = ordenservicioOld.orElseThrow();

            ordenServicioDb.setFechaOrden(ordenServicio.getFechaOrden());
            ordenServicioDb.setEstadoOrden(ordenServicio.getEstadoOrden());
            ordenServicioDb.setPersona(ordenServicio.getPersona());
            ordenServicioDb.setPersonas(ordenServicio.getPersonas());

            return Optional.of(ordenServicioRepository.save(ordenServicio));
       }
       return Optional.empty();
    }

    @Transactional
    @Override
    public Optional<OrdenServicio> delete(int id) {
        Optional<OrdenServicio> ordenservicioOptional = ordenServicioRepository.findById(id);
        ordenservicioOptional.ifPresent(ordenServicioDb -> {
            ordenServicioRepository.delete(ordenServicioDb);
        });
        return ordenservicioOptional;
    }

}
