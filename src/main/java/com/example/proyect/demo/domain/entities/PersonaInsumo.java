package com.example.proyect.demo.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "persona_insumo")
public class PersonaInsumo {

    @Id
    @Column(name = "id")
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "idInsumo")
    private Insumo insumo;

    @ManyToOne
    @JoinColumn(name = "numDoc")
    private Persona persona;
    
    @ManyToOne
    @JoinColumn(name = "idServicio")
    private Servicio servicio;
}
