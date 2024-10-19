package com.example.proyect.demo.infrastructure.repositories.insumo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.proyect.demo.application.services.IInsumoService;
import com.example.proyect.demo.domain.entities.Insumo;

@Repository
public class InsumoImpl implements IInsumoService{

    @Autowired
    private InsumoRepository insumoRepository;
 
    @Transactional(readOnly = true)
    @Override
    public List<Insumo> findAll() {
     return (List<Insumo>) insumoRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Insumo> findById(int id) {
        return insumoRepository.findById(id);
    }

    @Transactional
    @Override
    public Insumo save(Insumo insumo) {
       return insumoRepository.save(insumo);
    }

    @Transactional
    @Override
    public Optional<Insumo> update(int id, Insumo insumo) {
        Optional<Insumo> insumoOld = insumoRepository.findById(id);
        if (insumoOld.isPresent()) {
            Insumo insumoDb = insumoOld.orElseThrow();
            
            insumoDb.setCodInterno(insumo.getCodInterno());
            insumoDb.setNombreInsumo(insumo.getNombreInsumo());

            return Optional.of(insumoRepository.save(insumo));
        }
        return Optional.empty();
    }

    @Transactional
    @Override
    public Optional<Insumo> delete(int id) {
       Optional<Insumo> insumoOptional = insumoRepository.findById(id);
       insumoOptional.ifPresent(insumoDb -> {
            insumoRepository.delete(insumoDb);
       });
       return insumoOptional;
    }

    
   

}
