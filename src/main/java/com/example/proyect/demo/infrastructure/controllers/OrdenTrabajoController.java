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

import com.example.proyect.demo.application.services.IOrdenServicioService;
import com.example.proyect.demo.domain.entities.OrdenServicio;

@RestController
@RequestMapping("/ordtrabajo")
public class OrdenTrabajoController {

    @Autowired
    private IOrdenServicioService ordenServicioService;

    @GetMapping
    public List<OrdenServicio> List() {
        return ordenServicioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable int id) {
        Optional<OrdenServicio> paisOptional = ordenServicioService.findById(id);
        return paisOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody OrdenServicio ordenServicio) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ordenServicioService.save(ordenServicio));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody OrdenServicio ordenServicio) {
        Optional<OrdenServicio> updatedProduct = ordenServicioService.update(id, ordenServicio);
        return updatedProduct.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        Optional<OrdenServicio> productosDelete = ordenServicioService.delete(id);
        return productosDelete.map(c -> ResponseEntity.ok().build()).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
