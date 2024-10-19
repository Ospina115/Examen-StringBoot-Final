package com.example.proyect.demo.infrastructure.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.proyect.demo.application.services.IInsumoService;
import com.example.proyect.demo.domain.entities.Insumo;

@RestController
@RequestMapping("/insumo")
public class InsumoController {

    @Autowired
    private IInsumoService insumoService;

    @GetMapping
    public List<Insumo> List() {
        return insumoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable int id){
        Optional<Insumo> insumoOptional = insumoService.findById(id);
        return insumoOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody Insumo insumo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(insumoService.save(insumo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Insumo insumo ) {
        Optional<Insumo> updateInsumo = insumoService.update(id, insumo);
        return updateInsumo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
