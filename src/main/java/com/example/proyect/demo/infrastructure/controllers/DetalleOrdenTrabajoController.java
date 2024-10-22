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

import com.example.proyect.demo.application.services.IDetalleOrdenTrabajoService;
import com.example.proyect.demo.domain.entities.DetalleOrdenTrabajo;


@RestController
@RequestMapping("/detordtrabajo")
public class DetalleOrdenTrabajoController {

    @Autowired
    private IDetalleOrdenTrabajoService detalleOrdenTrabajoService;

    @GetMapping
    public List<DetalleOrdenTrabajo> list(){
        return detalleOrdenTrabajoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable int id) {
        Optional<DetalleOrdenTrabajo> detalleOrdenTrabajoOptional = detalleOrdenTrabajoService.findById(id);
        return detalleOrdenTrabajoOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody DetalleOrdenTrabajo detalleOrdenTrabajo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(detalleOrdenTrabajoService.save(detalleOrdenTrabajo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody DetalleOrdenTrabajo detalleOrdenTrabajo) {
        Optional<DetalleOrdenTrabajo> updateProduct = detalleOrdenTrabajoService.update(id, detalleOrdenTrabajo);
        return updateProduct.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        Optional<DetalleOrdenTrabajo> productDelete = detalleOrdenTrabajoService.delete(id);
        return productDelete.map(c -> ResponseEntity.ok().build()).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
