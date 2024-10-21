package com.example.proyect.demo.infrastructure.repositories.estadoorden;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.proyect.demo.domain.entities.EstadoOrden;

@Service
public interface EstadoOrdenRepository extends CrudRepository<EstadoOrden, Integer> {

}
