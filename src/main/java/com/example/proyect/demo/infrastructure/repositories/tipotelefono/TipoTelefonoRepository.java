package com.example.proyect.demo.infrastructure.repositories.tipotelefono;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.proyect.demo.domain.entities.TipoTelefono;

@Service
public interface TipoTelefonoRepository extends CrudRepository<TipoTelefono, Integer> {

}
