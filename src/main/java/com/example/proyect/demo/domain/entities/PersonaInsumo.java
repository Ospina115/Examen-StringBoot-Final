package com.example.proyect.demo.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "persona_insumo")
public class PersonaInsumo {

    @Id
    @Column(name = "idInsumo")
    private int idInsumo;

    @Id
    @Column(name = "numDoc")
    private int numDoc;

    @Column(name = "idServicio")
    private Long idServicio;


}
