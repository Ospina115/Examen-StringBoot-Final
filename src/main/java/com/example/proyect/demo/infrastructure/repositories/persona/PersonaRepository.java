package com.example.proyect.demo.infrastructure.repositories.persona;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.proyect.demo.domain.entities.Persona;

@Repository
public interface PersonaRepository extends CrudRepository<Persona, Integer>{

}
