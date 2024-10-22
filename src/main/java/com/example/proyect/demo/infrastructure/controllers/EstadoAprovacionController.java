package com.example.proyect.demo.infrastructure.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.proyect.demo.application.services.IEstadoAprovacionService;
import com.example.proyect.demo.domain.entities.EstadoAprovacion;

@RestController
@RequestMapping("/estaprovacion")
public class EstadoAprovacionController{

    @Autowired
    private IEstadoAprovacionService estadoAprovacionService;

    @GetMapping
    public List<EstadoAprovacion> list(){
        return estadoAprovacionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable int id) {
        Optional<EstadoAprovacion> estadoAprovacionOptional = estadoAprovacionService.finById(id);
        return estadoAprovacionOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody EstadoAprovacion estadoAprovacion) {
        return ResponseEntity.status(HttpStatus.CREATED).body(estadoAprovacionService.save(estadoAprovacion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody EstadoAprovacion estadoAprovacion) {
        Optional<EstadoAprovacion> updateProduct = estadoAprovacionService.update(id, estadoAprovacion);
        return updateProduct.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        Optional<EstadoAprovacion> productoDelete = estadoAprovacionService.delete(id);
        return productoDelete.map(c -> ResponseEntity.ok().build()).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
