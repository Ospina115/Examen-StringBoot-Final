package com.example.proyect.demo.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalle_orden")
public class DetalleOrden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "numOrden")
    private int numOrden;

    @Column(name = "idServicio")
    private Long idServicio;

    @Column(name = "valorServicio")
    private double valorServicio;
}
