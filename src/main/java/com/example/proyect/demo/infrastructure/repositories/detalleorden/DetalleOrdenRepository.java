package com.example.proyect.demo.infrastructure.repositories.detalleorden;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.proyect.demo.domain.entities.DetalleOrden;

@Service
public interface DetalleOrdenRepository extends CrudRepository<DetalleOrden, Integer>{

}
