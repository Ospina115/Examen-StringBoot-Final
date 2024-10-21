package com.example.proyect.demo.infrastructure.repositories.emailpersona;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.proyect.demo.domain.entities.EmailPersona;

@Repository
public interface EmailPersonaRepository extends CrudRepository<EmailPersona, Integer>{

}
