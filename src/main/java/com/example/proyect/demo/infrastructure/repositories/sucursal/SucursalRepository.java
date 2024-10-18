package com.example.proyect.demo.infrastructure.repositories.sucursal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.proyect.demo.domain.entities.Sucursal;

@Service
public interface SucursalRepository extends CrudRepository<Sucursal, Integer> {

}
