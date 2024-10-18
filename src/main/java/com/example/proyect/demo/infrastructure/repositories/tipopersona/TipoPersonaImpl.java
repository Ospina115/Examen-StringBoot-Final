package com.example.proyect.demo.infrastructure.repositories.tipopersona;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.proyect.demo.application.services.ITipoPersonaService;
import com.example.proyect.demo.domain.entities.TipoPersona;

@Service
public class TipoPersonaImpl implements ITipoPersonaService{

    @Autowired
    private TipoPersonaRepository tipoPersonaRepository;

    @Transactional(readOnly = true)
    @Override
    public List<TipoPersona> findAll() {
        return (List<TipoPersona>) tipoPersonaRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<TipoPersona> findById(int id) {
        return tipoPersonaRepository.findById(id);
    }

    @Transactional
    @Override
    public TipoPersona save(TipoPersona tipoPersona) {
        return tipoPersonaRepository.save(tipoPersona);
    }

    @Transactional
    @Override
    public Optional<TipoPersona> update(int id, TipoPersona tipoPersona) {
        Optional<TipoPersona> tipoPersonaOptional = tipoPersonaRepository.findById(id);
        if (tipoPersonaOptional.isPresent()) {
            TipoPersona tipoPersonaDb = tipoPersonaOptional.orElseThrow();
            tipoPersonaDb.setNombre(tipoPersona.getNombre());
            return Optional.of(tipoPersonaRepository.save(tipoPersonaDb));
        }
        return tipoPersonaOptional;
    }

    @Transactional
    @Override
    public Optional<TipoPersona> delete(int id) {
        Optional<TipoPersona> tipopersonaOptional = tipoPersonaRepository.findById(id);
        tipopersonaOptional.ifPresent(tipopersonaDb -> {
            tipoPersonaRepository.delete(tipopersonaDb);
        });
        return tipopersonaOptional;
    }

}
