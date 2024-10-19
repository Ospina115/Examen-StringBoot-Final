package com.example.proyect.demo.infrastructure.repositories.insumo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.proyect.demo.domain.entities.Insumo;

@Service
public interface InsumoRepository extends CrudRepository<Insumo, Integer>{

}
