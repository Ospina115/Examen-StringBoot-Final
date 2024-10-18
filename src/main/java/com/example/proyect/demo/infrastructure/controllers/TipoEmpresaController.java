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

import com.example.proyect.demo.application.services.ITipoEmpresaService;
import com.example.proyect.demo.domain.entities.TipoEmpresa;

@RestController
@RequestMapping("/tpempresas")
public class TipoEmpresaController {
    @Autowired
    private ITipoEmpresaService tipoEmpresaService;

    @GetMapping
    public List<TipoEmpresa> list(){
        return tipoEmpresaService.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable int id) {
        Optional<TipoEmpresa> regionOptional = tipoEmpresaService.findById(id);
        return regionOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @PostMapping()
    public ResponseEntity<?> create(@RequestBody TipoEmpresa tipoEmpresa) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tipoEmpresaService.save(tipoEmpresa));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody TipoEmpresa tipoEmpresa) {
        Optional<TipoEmpresa> updateProduct = tipoEmpresaService.update(id, tipoEmpresa);
        return updateProduct.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        Optional<TipoEmpresa> productoDelete =tipoEmpresaService.delete(id);
        return productoDelete.map(c -> ResponseEntity.ok().build()).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
