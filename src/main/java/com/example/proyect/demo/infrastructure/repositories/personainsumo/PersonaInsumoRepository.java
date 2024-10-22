package com.example.proyect.demo.infrastructure.repositories.personainsumo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.proyect.demo.domain.entities.PersonaInsumo;

@Service
public interface PersonaInsumoRepository extends CrudRepository<PersonaInsumo, Integer>{

}
