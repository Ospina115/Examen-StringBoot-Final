package com.example.proyect.demo.infrastructure.repositories.tipoempresa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.proyect.demo.application.services.ITipoEmpresaService;
import com.example.proyect.demo.domain.entities.TipoEmpresa;

@Service
public class TipoEmpresaImpl implements ITipoEmpresaService {

    @Autowired
    private TipoEmpresaRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<TipoEmpresa> findAll() {
        return (List<TipoEmpresa>) repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<TipoEmpresa> findById(int id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public TipoEmpresa save(TipoEmpresa tipoEmpresa) {
        return repository.save(tipoEmpresa);
    }

    @Transactional
    @Override
    public Optional<TipoEmpresa> update(int id, TipoEmpresa tipoEmpresa) {
        Optional<TipoEmpresa> tipoEmpresaOptional = repository.findById(id);
        if (tipoEmpresaOptional.isPresent()) {
            TipoEmpresa tipoEmpresaDb = tipoEmpresaOptional.orElseThrow();
            tipoEmpresaDb.setDescripcion(tipoEmpresa.getDescripcion());
            return Optional.of(repository.save(tipoEmpresaDb));
        }
        return tipoEmpresaOptional;
    }
    
    @Transactional
    @Override
    public Optional<TipoEmpresa> delete(int id) {
        Optional<TipoEmpresa> productoOptional = repository.findById(id);
        productoOptional.ifPresent(productDb -> {
            repository.delete(productDb);
        });
        return productoOptional;
    }

}
