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

import com.example.proyect.demo.application.services.IAprovacionServicioService;
import com.example.proyect.demo.domain.entities.AprovacionServicio;

@RestController
@RequestMapping("/aproservicio")
public class AprovacionServicioController {

    @Autowired
    private IAprovacionServicioService aprovacionServicioService;

    @GetMapping
    public List<AprovacionServicio> list(){
        return aprovacionServicioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable int id) {
        Optional<AprovacionServicio> aprovacionServicioOptional = aprovacionServicioService.findById(id);
        return aprovacionServicioOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody AprovacionServicio aprovacionServicio) {
        return ResponseEntity.status(HttpStatus.CREATED).body(aprovacionServicioService.save(aprovacionServicio));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody AprovacionServicio aprovacionServicio) {
        Optional<AprovacionServicio> updateProduct = aprovacionServicioService.update(id, aprovacionServicio);
        return updateProduct.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        Optional<AprovacionServicio> productoDelete =aprovacionServicioService.delete(id);
        return productoDelete.map(c -> ResponseEntity.ok().build()).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
