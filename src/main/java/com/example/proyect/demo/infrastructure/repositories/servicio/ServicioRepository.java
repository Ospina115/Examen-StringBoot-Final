package com.example.proyect.demo.infrastructure.repositories.servicio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.proyect.demo.domain.entities.Servicio;

@Service
public interface ServicioRepository extends CrudRepository<Servicio, Integer>{

}
