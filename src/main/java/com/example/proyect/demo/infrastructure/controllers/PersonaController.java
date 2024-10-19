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

import com.example.proyect.demo.application.services.IPersonaService;
import com.example.proyect.demo.domain.entities.Persona;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    private IPersonaService personaService;

    @GetMapping
    public List<Persona> List() {
        return personaService.findAll();
    }

    @GetMapping("/{numDoc}")
    public ResponseEntity<?> view(@PathVariable int numDoc){
          Optional<Persona> personaOptional = personaService.findById(numDoc);
          return personaOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody Persona persona) {
        return ResponseEntity.status(HttpStatus.CREATED).body(personaService.save(persona));
    }

    @PutMapping("/{numDoc}")
    public ResponseEntity<?> update(@PathVariable int numDoc, @RequestBody Persona persona) {
        Optional<Persona> updatedPersona = personaService.update(numDoc, persona);
        return updatedPersona.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
