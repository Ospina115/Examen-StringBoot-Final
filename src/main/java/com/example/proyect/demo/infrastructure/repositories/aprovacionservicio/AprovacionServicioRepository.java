package com.example.proyect.demo.infrastructure.repositories.aprovacionservicio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.proyect.demo.domain.entities.AprovacionServicio;

@Repository
public interface AprovacionServicioRepository extends CrudRepository<AprovacionServicio, Integer>{

}
