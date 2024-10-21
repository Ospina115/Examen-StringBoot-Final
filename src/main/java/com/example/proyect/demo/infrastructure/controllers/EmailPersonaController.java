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

import com.example.proyect.demo.application.services.IEmailPersonaService;
import com.example.proyect.demo.domain.entities.EmailPersona;

@RestController
@RequestMapping("/emailperson")
public class EmailPersonaController {

    @Autowired
    private IEmailPersonaService emailPersonaService;

    @GetMapping
    public List<EmailPersona> list(){
        return emailPersonaService.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable int id) {
        Optional<EmailPersona> regionOptional = emailPersonaService.findById(id);
        return regionOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @PostMapping()
    public ResponseEntity<?> create(@RequestBody EmailPersona emailPersona) {
        return ResponseEntity.status(HttpStatus.CREATED).body(emailPersonaService.save(emailPersona));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody EmailPersona emailPersona) {
        Optional<EmailPersona> updateProduct = emailPersonaService.update(id, emailPersona);
        return updateProduct.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        Optional<EmailPersona> productoDelete =emailPersonaService.delete(id);
        return productoDelete.map(c -> ResponseEntity.ok().build()).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
