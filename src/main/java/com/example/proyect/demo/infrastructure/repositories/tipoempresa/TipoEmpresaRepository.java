package com.example.proyect.demo.infrastructure.repositories.tipoempresa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.proyect.demo.domain.entities.TipoEmpresa;

@Repository
public interface TipoEmpresaRepository extends CrudRepository<TipoEmpresa, Integer>{

}
