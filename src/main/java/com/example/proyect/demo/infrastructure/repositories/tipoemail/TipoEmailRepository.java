package com.example.proyect.demo.infrastructure.repositories.tipoemail;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.proyect.demo.domain.entities.TipoEmail;

@Repository
public interface TipoEmailRepository extends CrudRepository<TipoEmail, Integer>{

}
