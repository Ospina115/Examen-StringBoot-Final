package com.example.proyect.demo.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "servicio_insumo")
public class ServicioInsumo {

    @Id
    @Column(name = "idServicio")
    private Long idServicio;

    @Id
    @Column(name = "idConsumo")
    private Long idConsumo;

    @Column(name = "valorUnitario")
    private double valorUnitario;

    @Column(name = "stock")
    private int stock;

    @Column(name = "stockMin")
    private long stockMin;

    @Column(name = "stockMax")
    private long stockMax;

}
