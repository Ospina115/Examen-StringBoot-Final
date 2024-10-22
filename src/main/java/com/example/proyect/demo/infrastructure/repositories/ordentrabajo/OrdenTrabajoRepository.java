package com.example.proyect.demo.infrastructure.repositories.ordentrabajo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.proyect.demo.domain.entities.OrdenTrabajo;

@Service
public interface OrdenTrabajoRepository extends CrudRepository<OrdenTrabajo, Integer>{

}
