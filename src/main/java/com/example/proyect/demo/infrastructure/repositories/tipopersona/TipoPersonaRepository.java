package com.example.proyect.demo.infrastructure.repositories.tipopersona;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.proyect.demo.domain.entities.TipoPersona;

@Repository
public interface TipoPersonaRepository extends CrudRepository<TipoPersona, Integer>{

}
