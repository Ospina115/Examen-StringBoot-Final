package com.example.proyect.demo.domain.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "detalle_orden_trabajo")
@Data
public class DetalleOrdenTrabajo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "idOrdenTrabajo")
    private Long idOrdenTrabajo;

    @Column(name = "idServicioAsignado")
    private Long idServicioAsignado;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "idEstadoOrdenServicio")
    private Long idEstadoOrdenServicio;
}
