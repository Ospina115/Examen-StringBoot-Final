package com.example.proyect.demo.infrastructure.repositories.pais;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.proyect.demo.application.services.IPaisService;
import com.example.proyect.demo.domain.entities.Pais;

@Service
public class PaisImpl implements IPaisService{

    @Autowired
    private PaisRepository paisRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Pais> findAll() {
        return (List<Pais>)paisRepository.findAll();
    }
    
    @Transactional(readOnly = true)
    @Override
    public Optional<Pais> findById(int id) {
        return paisRepository.findById(id);
    }

    @Transactional
    @Override
    public Pais save(Pais pais) {
        return paisRepository.save(pais);
    }

    @Transactional
    @Override
    public Optional<Pais> update(int id, Pais pais) {
        Optional<Pais> paisOld = paisRepository.findById(id);
        if(paisOld.isPresent()){
            Pais paisDb = paisOld.orElseThrow();

            paisDb.setNombre(pais.getNombre());
            
            return Optional.of(paisRepository.save(pais));
        }
        return Optional.empty();
    }

    @Transactional
    @Override
    public Optional<Pais> delete(int id) {
       Optional<Pais> paisOptional = paisRepository.findById(id);
       paisOptional.ifPresent(paisDb -> {
            paisRepository.delete(paisDb);
       });
       return paisOptional;
    }

    
}
