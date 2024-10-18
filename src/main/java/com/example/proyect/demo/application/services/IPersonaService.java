package com.example.proyect.demo.application.services;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.example.proyect.demo.domain.entities.Persona;

@Service
public interface IPersonaService {

    List<Persona> findAll();

    Optional<Persona> findById(int numDoc);

    Persona save(Persona persona);

    Optional<Persona> update(int numDoc, Persona persona);

    Optional<Persona> delete(int numDoc);
}
