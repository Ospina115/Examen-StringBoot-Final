package com.example.proyect.demo.domain.entities;

import java.sql.Date;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "orden_trabajo")
public class OrdenTrabajo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "numOrdenTrabajo")
    private int numOrdenTrabajo;

    @Column(name = "fechaAsignacion")
    private Date fechaAsignacion;

    @Column(name = "horaAsignacion")
    private LocalTime horaAsignacion;

    @Column(name = "idEmpleado")
    private Long idEmpleado;

    @Column(name = "numOrden")
    private Long numOrden;
    
}
