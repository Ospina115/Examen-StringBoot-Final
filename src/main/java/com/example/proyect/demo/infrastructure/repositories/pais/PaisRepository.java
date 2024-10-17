package com.example.proyect.demo.infrastructure.repositories.pais;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.proyect.demo.domain.entities.Pais;

@Repository
public interface PaisRepository extends CrudRepository<Pais, Integer>{

}
