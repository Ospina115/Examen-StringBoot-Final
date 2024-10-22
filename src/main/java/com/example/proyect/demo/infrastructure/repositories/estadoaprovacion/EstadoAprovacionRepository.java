package com.example.proyect.demo.infrastructure.repositories.estadoaprovacion;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.proyect.demo.domain.entities.EstadoAprovacion;

@Service
public interface EstadoAprovacionRepository extends CrudRepository<EstadoAprovacion, Integer>{

}
