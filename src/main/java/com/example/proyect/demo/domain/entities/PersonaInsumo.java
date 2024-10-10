package com.example.proyect.demo.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "persona_insumo")
public class PersonaInsumo {

    @Id
    @Column(name = "idServicio")
    private int idServicio;

    @Id
    @Column(name = "idConsumo")
    private int idConsumo;

    @Column(name = "valorUnitario")
    private double valorUnitario;

    @Column(name = "stock")
    private int stock;

    @Column(name = "stockMin")
    private long stockMin;

    @Column(name = "stockMax")
    private long stockMax;
}
