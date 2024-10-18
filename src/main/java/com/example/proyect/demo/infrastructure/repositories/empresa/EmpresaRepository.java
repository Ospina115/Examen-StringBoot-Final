package com.example.proyect.demo.infrastructure.repositories.empresa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.proyect.demo.domain.entities.Empresa;

@Repository
public interface EmpresaRepository extends CrudRepository<Empresa, Integer>{

}
