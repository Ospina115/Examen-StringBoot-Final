package com.example.proyect.demo.infrastructure.repositories.sucursal;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.proyect.demo.application.services.ISucursalService;
import com.example.proyect.demo.domain.entities.Sucursal;

@Service
public class SucursalImpl implements ISucursalService{
    @Autowired
    private SucursalRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<Sucursal> findAll() {
        return (List<Sucursal>) repository.findAll();
    }

    @Override
    public Optional<Sucursal> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public Sucursal save(Sucursal sucursal) {
        return repository.save(sucursal);
    }

    @Override
    public Optional<Sucursal> update(int id, Sucursal sucursal) {
        Optional<Sucursal> sucursalOptional = repository.findById(id);
        if (sucursalOptional.isPresent()) {
            Sucursal sucursalDb = sucursalOptional.orElseThrow();
            sucursalDb.setNombreSuc(sucursal.getNombreSuc());
            sucursalDb.setNit(sucursal.getNit());
            sucursalDb.setFechaCreacion(sucursal.getFechaCreacion());
            sucursalDb.setCiudad(sucursal.getCiudad());
            sucursalDb.setEmpresa(sucursal.getEmpresa());
            return Optional.of(repository.save(sucursalDb));
        }
        return sucursalOptional;
    }

    @Override
    public Optional<Sucursal> delete(int id) {
        Optional<Sucursal> productoOptional = repository.findById(id);
        productoOptional.ifPresent(productDb -> {
            repository.delete(productDb);
        });
        return productoOptional;
    }
}
