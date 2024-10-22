package com.example.proyect.demo.infrastructure.repositories.detalleordentrabajo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.proyect.demo.domain.entities.DetalleOrdenTrabajo;

@Service
public interface DetalleOrdenTrabajoRepository extends CrudRepository<DetalleOrdenTrabajo, Integer>{

}
