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

import com.example.proyect.demo.application.services.IPersonaInsumoService;
import com.example.proyect.demo.domain.entities.PersonaInsumo;

@RestController
@RequestMapping("/perinsumo")
public class PersonaInsumoController {


    @Autowired
    private IPersonaInsumoService personaInsumoService;

    @GetMapping
    public List<PersonaInsumo> List() {
        return personaInsumoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable int id){
        Optional<PersonaInsumo> personaOptional = personaInsumoService.findById(id);
        return personaOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody PersonaInsumo personaInsumo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(personaInsumoService.save(personaInsumo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody PersonaInsumo personaInsumo) {
        Optional<PersonaInsumo> updatedPersona = personaInsumoService.update(id, personaInsumo);
        return updatedPersona.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
