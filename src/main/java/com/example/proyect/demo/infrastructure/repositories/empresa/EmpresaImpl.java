package com.example.proyect.demo.infrastructure.repositories.empresa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.proyect.demo.application.services.IEmpresaService;
import com.example.proyect.demo.domain.entities.Empresa;

@Service
public class EmpresaImpl implements IEmpresaService {
    @Autowired
    private EmpresaRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<Empresa> findAll() {
        return (List<Empresa>) repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Empresa> findById(int id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Empresa save(Empresa empresa) {
        return repository.save(empresa);
    }

    @Transactional
    @Override
    public Optional<Empresa> update(int id, Empresa empresa) {
        Optional<Empresa> empresaOptional = repository.findById(id);
        if (empresaOptional.isPresent()) {
            Empresa empresaDb = empresaOptional.orElseThrow();
            empresaDb.setNombre(empresa.getNombre());
            empresaDb.setTipoEmpresa(empresa.getTipoEmpresa());
            return Optional.of(repository.save(empresaDb));
        }
        return empresaOptional;
    }

    @Transactional
    @Override
    public Optional<Empresa> delete(int id) {
        Optional<Empresa> productoOptional = repository.findById(id);
        productoOptional.ifPresent(productDb -> {
            repository.delete(productDb);
        });
        return productoOptional;
    }
}
