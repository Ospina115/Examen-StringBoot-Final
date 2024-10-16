package com.example.proyect.demo.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "servicio_insumo")
public class ServicioInsumo {

    @Id
    @Column(name = "id_servicio")
    private int idServicio;

    @Id
    @Column(name = "id_insumo")
    private int idInsumo;

    @Column(name = "valorUnitario")
    private double valorUnitario;

    @Column(name = "stock")
    private int stock;

    @Column(name = "stockMin")
    private long stockMin;

    @Column(name = "stockMax")
    private long stockMax;

    @ManyToOne
    @JoinColumn(name = "id_servicio", referencedColumnName = "id", insertable = false, updatable = false)
    private Servicio servicio;

    @ManyToOne
    @JoinColumn(name = "id_insumo", referencedColumnName = "id", insertable = false, updatable = false)
    private Insumo insumo;
}
