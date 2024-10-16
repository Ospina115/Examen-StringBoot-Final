package com.example.proyect.demo.domain.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "insumo")
public class Insumo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "codInterno", length = 50)
    private String codInterno;

    @Column(name = "nombreInsumo", length = 50)
    private String nombreInsumo;

    @OneToMany(mappedBy = "insumo")
    @JsonIgnore
    private List<PersonaInsumo> personaInsumos;
}
