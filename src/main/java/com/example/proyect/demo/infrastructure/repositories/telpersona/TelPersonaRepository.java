package com.example.proyect.demo.infrastructure.repositories.telpersona;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.proyect.demo.domain.entities.TelPersona;

@Service
public interface TelPersonaRepository extends CrudRepository<TelPersona, Integer> {

}
