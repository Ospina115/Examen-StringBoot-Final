package com.example.proyect.demo.infrastructure.repositories.ciudad;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.proyect.demo.application.services.ICiudadService;
import com.example.proyect.demo.domain.entities.Ciudad;

@Service
public class CiudadImpl implements ICiudadService {

    @Autowired
    private CiudadRepository ciudadRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Ciudad> findAll() {
        return (List<Ciudad>)ciudadRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Ciudad> findById(int id) {
        return ciudadRepository.findById(id);
    }

    @Transactional
    @Override
    public Ciudad save(Ciudad ciudad) {
        return ciudadRepository.save(ciudad);   
    }

    @Transactional
    @Override
    public Optional<Ciudad> update(int id, Ciudad ciudad) {
        Optional<Ciudad> ciudadOld = ciudadRepository.findById(id);
        if (ciudadOld.isPresent()) {
            Ciudad ciudadDb = ciudadOld.orElseThrow();

            ciudadDb.setNombre(ciudad.getNombre());
            ciudadDb.setRegion(ciudad.getRegion());

            return Optional.of(ciudadRepository.save(ciudad));
        }
        return Optional.empty();
    }

    @Transactional
    @Override
    public Optional<Ciudad> delete(int id) {
        Optional<Ciudad> ciudadOptional = ciudadRepository.findById(id);
        ciudadOptional.ifPresent(ciudadDb -> {
            ciudadRepository.delete(ciudadDb);
        });
        return ciudadOptional;
    }

}
