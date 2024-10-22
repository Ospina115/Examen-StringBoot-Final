package com.example.proyect.demo.infrastructure.repositories.personainsumo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.proyect.demo.application.services.IPersonaInsumoService;
import com.example.proyect.demo.domain.entities.PersonaInsumo;

@Service
public class PersonaInsumoImpl implements IPersonaInsumoService{

    @Autowired
    private PersonaInsumoRepository personaInsumoRepository;

    @Transactional(readOnly = true)
    @Override
    public List<PersonaInsumo> findAll() {
        return (List<PersonaInsumo>) personaInsumoRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<PersonaInsumo> findById(int id) {
       return personaInsumoRepository.findById(id);
    }

    @Transactional
    @Override
    public PersonaInsumo save(PersonaInsumo personaInsumo) {
       return personaInsumoRepository.save(personaInsumo);
    }

    @Transactional
    @Override
    public Optional<PersonaInsumo> update(int id, PersonaInsumo personaInsumo) {
       Optional<PersonaInsumo> personaInsumoOptional = personaInsumoRepository.findById(id);
       if (personaInsumoOptional.isPresent()) {
            PersonaInsumo personaInsumoDb = personaInsumoOptional.orElseThrow();
            personaInsumoDb.setInsumo(personaInsumo.getInsumo());
            personaInsumoDb.setPersona(personaInsumo.getPersona());
            personaInsumoDb.setServicio(personaInsumo.getServicio());
            return Optional.of(personaInsumoRepository.save(personaInsumoDb));
       }
       return personaInsumoOptional;
    }

    @Transactional
    @Override
    public Optional<PersonaInsumo> delete(int id) {
        Optional<PersonaInsumo> personaInsumoOptional = personaInsumoRepository.findById(id);
        personaInsumoOptional.ifPresent(personaInsumoDb -> {
            personaInsumoRepository.delete(personaInsumoDb);
        });
        return personaInsumoOptional;
    }
}
