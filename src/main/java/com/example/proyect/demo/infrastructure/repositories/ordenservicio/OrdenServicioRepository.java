package com.example.proyect.demo.infrastructure.repositories.ordenservicio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.proyect.demo.domain.entities.OrdenServicio;

@Repository
public interface OrdenServicioRepository extends CrudRepository<OrdenServicio, Integer> {

}
