package com.example.proyect.demo.infrastructure.repositories.persona;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.proyect.demo.application.services.IPersonaService;
import com.example.proyect.demo.domain.entities.Persona;

@Service
public class PersonaImpl implements IPersonaService{

    @Autowired
    private PersonaRepository personaRepository;
    
    @Transactional(readOnly = true)
    @Override
    public List<Persona> findAll() {
        return (List<Persona>) personaRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Persona> findById(int numDoc) {
        return personaRepository.findById(numDoc);
    }

    @Transactional
    @Override
    public Persona save(Persona persona) {
        return personaRepository.save(persona);
    }

    @Transactional
    @Override
    public Optional<Persona> update(int numDoc, Persona persona) {
        Optional<Persona> perOptional = personaRepository.findById(numDoc);
        if (perOptional.isPresent()) {
            Persona personaDb = perOptional.orElseThrow();
            personaDb.setNumDoc(persona.getNumDoc());
            personaDb.setNombre(persona.getNombre());
            personaDb.setApellido(persona.getApellido());
            personaDb.setFechaRegistro(persona.getFechaRegistro());
            personaDb.setSucursal(persona.getSucursal());
            personaDb.setDireccion(persona.getDireccion());
            personaDb.setTipoPersonas(persona.getTipoPersonas());
            return Optional.of(personaRepository.save(personaDb));
        }
        return perOptional;
    }

    @Transactional
    @Override
    public Optional<Persona> delete(int numDoc) {
        Optional<Persona> personaOptional = personaRepository.findById(numDoc);
        personaOptional.ifPresent(personaDb -> {
            personaRepository.delete(personaDb);
        });
        return personaOptional;
    }
}
