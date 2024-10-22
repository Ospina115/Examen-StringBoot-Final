package com.example.proyect.demo.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.proyect.demo.domain.entities.PersonaInsumo;

@Service
public interface IPersonaInsumoService {

    List<PersonaInsumo> findAll();

    Optional<PersonaInsumo> findById(int id);

    PersonaInsumo save(PersonaInsumo personaInsumo);

    Optional<PersonaInsumo> update(int id, PersonaInsumo personaInsumo);

    Optional<PersonaInsumo> delete(int id);
}
