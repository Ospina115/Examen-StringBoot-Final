package com.example.proyect.demo.infrastructure.repositories.ciudad;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.proyect.demo.domain.entities.Ciudad;

@Repository
public interface CiudadRepository extends CrudRepository<Ciudad, Integer>{

}
