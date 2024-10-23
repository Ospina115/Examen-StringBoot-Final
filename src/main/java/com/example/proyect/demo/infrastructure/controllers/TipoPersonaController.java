package com.example.proyect.demo.infrastructure.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.proyect.demo.application.services.ITipoPersonaService;
import com.example.proyect.demo.domain.entities.TipoPersona;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/tipopersona")
public class TipoPersonaController {
    @Autowired
    private ITipoPersonaService tipoPersonaService;

    @GetMapping
    public List<TipoPersona> list() {
        return tipoPersonaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable int id) {
        Optional<TipoPersona> tipoPersonaOptional = tipoPersonaService.findById(id);
        return tipoPersonaOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @PostMapping()
    public ResponseEntity<?> create(@RequestBody TipoPersona tipoPersona) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tipoPersonaService.save(tipoPersona));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody TipoPersona tipoPersona) {
        Optional<TipoPersona> updateProduct = tipoPersonaService.update(id, tipoPersona);
        return updateProduct.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        Optional<TipoPersona> productoDelete =tipoPersonaService.delete(id);
        return productoDelete.map(c -> ResponseEntity.ok().build()).orElseGet(() -> ResponseEntity.notFound().build());
    } 
}
