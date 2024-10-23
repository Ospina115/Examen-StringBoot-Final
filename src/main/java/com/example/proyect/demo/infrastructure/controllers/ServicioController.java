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

import com.example.proyect.demo.application.services.IServicioService;
import com.example.proyect.demo.domain.entities.Servicio;

@RestController
@RequestMapping("/servicios")
public class ServicioController {

    @Autowired
    private IServicioService servicioService;

    @GetMapping
    public List<Servicio> list(){
        return servicioService.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable int id) {
        Optional<Servicio> regionOptional = servicioService.findById(id);
        return regionOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @PostMapping()
    public ResponseEntity<?> create(@RequestBody Servicio servicio) {
        return ResponseEntity.status(HttpStatus.CREATED).body(servicioService.save(servicio));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Servicio servicio) {
        Optional<Servicio> updateProduct = servicioService.update(id, servicio);
        return updateProduct.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        Optional<Servicio> productoDelete =servicioService.delete(id);
        return productoDelete.map(c -> ResponseEntity.ok().build()).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
