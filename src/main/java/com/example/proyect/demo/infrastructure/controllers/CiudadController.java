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

import com.example.proyect.demo.application.services.ICiudadService;
import com.example.proyect.demo.domain.entities.Ciudad;


@RestController
@RequestMapping("/ciudades")
public class CiudadController {

    @Autowired
    private ICiudadService ciudadService;

    @GetMapping
    public List<Ciudad> List() {
        return ciudadService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable int id){
        Optional<Ciudad> ciudadOptional = ciudadService.findById(id);
        return ciudadOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody Ciudad ciudad) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ciudadService.save(ciudad));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Ciudad ciudad) {
        Optional<Ciudad> updatedProduct = ciudadService.update(id, ciudad);
        return updatedProduct.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        Optional<Ciudad> productosDelete = ciudadService.delete(id);
        return productosDelete.map(c -> ResponseEntity.ok().build()).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
