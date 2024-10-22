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

import com.example.proyect.demo.application.services.IDetalleOrdenService;
import com.example.proyect.demo.domain.entities.DetalleOrden;


@RestController
@RequestMapping("/detorden")
public class DetalleOrdenController {

    @Autowired
    private IDetalleOrdenService detalleOrdenService;

    @GetMapping
    public List<DetalleOrden> list(){
        return detalleOrdenService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable int id) {
        Optional<DetalleOrden> detalleOrdenOptional = detalleOrdenService.findById(id);
        return detalleOrdenOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody DetalleOrden detalleOrden) {
        return ResponseEntity.status(HttpStatus.CREATED).body(detalleOrdenService.save(detalleOrden));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody DetalleOrden detalleOrden) {
        Optional<DetalleOrden> updateProduct = detalleOrdenService.update(id, detalleOrden);
        return updateProduct.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        Optional<DetalleOrden> productDelete = detalleOrdenService.delete(id);
        return productDelete.map(c -> ResponseEntity.ok().build()).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
