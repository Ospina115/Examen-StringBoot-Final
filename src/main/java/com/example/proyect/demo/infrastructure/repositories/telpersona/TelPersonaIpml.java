package com.example.proyect.demo.infrastructure.repositories.telpersona;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.proyect.demo.application.services.ITelPersonaService;
import com.example.proyect.demo.domain.entities.TelPersona;

@Service
public class TelPersonaIpml implements ITelPersonaService {
    @Autowired
    private TelPersonaRepository repository;


    @Transactional(readOnly = true)
    @Override
    public List<TelPersona> findAll() {
        return (List<TelPersona>) repository.findAll();
    }

    @Override
    public Optional<TelPersona> findById(int id) {
        return repository.findById(id);
    } 

    @Override
    public TelPersona save(TelPersona telPersona) {
        return repository.save(telPersona);
    }

    @Override
    public Optional<TelPersona> update(int id, TelPersona telPersona) {
        Optional<TelPersona> telPersonaOptional = repository.findById(id);
        if (telPersonaOptional.isPresent()) {
            TelPersona telPersonaDb = telPersonaOptional.orElseThrow();
            telPersonaDb.setNumero(telPersona.getNumero());
            telPersonaDb.setPersona(telPersona.getPersona());
            telPersonaDb.setTipoTelefonos(telPersona.getTipoTelefonos());
            return Optional.of(repository.save(telPersonaDb));
        }
        return telPersonaOptional;
    }

    @Override
    public Optional<TelPersona> delete(int id) {
        Optional<TelPersona> productoOptional = repository.findById(id);
        productoOptional.ifPresent(productDb -> {
            repository.delete(productDb);
        });
        return productoOptional;
    }
}
