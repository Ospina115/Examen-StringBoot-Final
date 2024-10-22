package com.example.proyect.demo.infrastructure.repositories.aprovacionservicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.proyect.demo.application.services.IAprovacionServicioService;
import com.example.proyect.demo.domain.entities.AprovacionServicio;

@Service
public class AprovacionServicioImpl implements IAprovacionServicioService{

    @Autowired
    private AprovacionServicioRepository aprovacionServicioRepository;

    @Transactional(readOnly = true)
    @Override
    public List<AprovacionServicio> findAll() {
        return (List<AprovacionServicio>)aprovacionServicioRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<AprovacionServicio> findById(int id) {
        return aprovacionServicioRepository.findById(id);
    }

    @Transactional
    @Override
    public AprovacionServicio save(AprovacionServicio aprovacionServicio) {
       return aprovacionServicioRepository.save(aprovacionServicio);
    }

    @Transactional
    @Override
    public Optional<AprovacionServicio> update(int id, AprovacionServicio aprovacionServicio) {
        Optional<AprovacionServicio> aprovacionServicioOld = aprovacionServicioRepository.findById(id);
        if (aprovacionServicioOld.isPresent()) {
            AprovacionServicio aprovacionServicioDb = aprovacionServicioOld.orElseThrow();

            aprovacionServicioDb.setOrdenTrabajo(aprovacionServicio.getOrdenTrabajo());
            aprovacionServicioDb.setIdCliente(aprovacionServicio.getIdCliente());
            aprovacionServicioDb.setServicio(aprovacionServicio.getServicio());
            aprovacionServicioDb.setHallazgo(aprovacionServicio.getHallazgo());
            aprovacionServicioDb.setSolucion(aprovacionServicio.getSolucion());
            aprovacionServicioDb.setEstadoAprovacion(aprovacionServicio.getEstadoAprovacion());

            return Optional.of(aprovacionServicioRepository.save(aprovacionServicio));
        }
        return Optional.empty();
    }

    @Transactional
    @Override
    public Optional<AprovacionServicio> delete(int id) {
       Optional<AprovacionServicio> aprovacionServicioOptional = aprovacionServicioRepository.findById(id);

       aprovacionServicioOptional.ifPresent(aprovacionServicioDb -> {
            aprovacionServicioRepository.delete(aprovacionServicioDb);
       });
       return aprovacionServicioOptional;
    }


}
