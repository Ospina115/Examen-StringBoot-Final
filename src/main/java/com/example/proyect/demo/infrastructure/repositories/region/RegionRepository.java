package com.example.proyect.demo.infrastructure.repositories.region;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.proyect.demo.domain.entities.Region;

@Repository
public interface RegionRepository extends CrudRepository<Region, Integer>{

}