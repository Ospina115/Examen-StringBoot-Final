package com.example.proyect.demo.infrastructure.repositories.region;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.proyect.demo.application.services.IRegionService;
import com.example.proyect.demo.domain.entities.Region;

@Service
public class RegionImpl implements IRegionService {

    @Autowired
    private RegionRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<Region> findAll() {
        return (List<Region>) repository.findAll();
    }

    @Override
    public Optional<Region> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public Region save(Region region) {
        return repository.save(region);
    }

    @Override
    public Optional<Region> update(int id, Region region) {
        Optional<Region> regionOptional = repository.findById(id);
        if (regionOptional.isPresent()) {
            Region regionDb = regionOptional.orElseThrow();
            regionDb.setNombre(region.getNombre());
            return Optional.of(repository.save(regionDb));
        }
        return regionOptional;
    }

    @Override
    public Optional<Region> delete(int id) {
        Optional<Region> productoOptional = repository.findById(id);
        productoOptional.ifPresent(productDb -> {
            repository.delete(productDb);
        });
        return productoOptional;
    }

}
