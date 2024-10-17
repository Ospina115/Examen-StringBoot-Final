package com.example.proyect.demo.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.proyect.demo.domain.entities.Pais;

@Service
public interface IPaisService {

    List<Pais> findAll();

    Optional<Pais> findById(int id);
}
