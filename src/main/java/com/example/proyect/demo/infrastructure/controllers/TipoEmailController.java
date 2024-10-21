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

import com.example.proyect.demo.application.services.ITipoEmailService;
import com.example.proyect.demo.domain.entities.TipoEmail;

@RestController
@RequestMapping("/tpemail")
public class TipoEmailController {

    @Autowired
    private ITipoEmailService tipoEmailService;

    @GetMapping
    public List<TipoEmail> list(){
        return tipoEmailService.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable int id) {
        Optional<TipoEmail> regionOptional = tipoEmailService.findById(id);
        return regionOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @PostMapping()
    public ResponseEntity<?> create(@RequestBody TipoEmail tipoEmail) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tipoEmailService.save(tipoEmail));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody TipoEmail tipoEmail) {
        Optional<TipoEmail> updateProduct = tipoEmailService.update(id, tipoEmail);
        return updateProduct.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        Optional<TipoEmail> productoDelete =tipoEmailService.delete(id);
        return productoDelete.map(c -> ResponseEntity.ok().build()).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
