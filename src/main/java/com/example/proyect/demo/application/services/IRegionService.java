package com.example.proyect.demo.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.proyect.demo.domain.entities.Region;

@Service
public interface IRegionService {

    List<Region> findAll();

    Optional<Region> findById(int id);

    Region save(Region region);

    Optional<Region> update(int id, Region region);

    Optional<Region> delete(int id);
}
