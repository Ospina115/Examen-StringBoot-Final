package com.example.proyect.demo.infrastructure.repositories.direccion;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.proyect.demo.domain.entities.Direccion;

@Service
public interface DireccionRepository extends CrudRepository<Direccion, Integer> {

}
