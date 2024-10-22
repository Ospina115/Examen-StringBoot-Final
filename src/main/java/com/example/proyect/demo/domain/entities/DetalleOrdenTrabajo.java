package com.example.proyect.demo.domain.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    private int id;

    @ManyToOne
    @JoinColumn(name = "idOrdenTrabajo")
    private OrdenTrabajo ordenTrabajo;

    @ManyToOne
    @JoinColumn(name = "idServicioAsignado")
    private Servicio servicio;

    @Column(name = "fecha")
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "idEstadoOrdenServicio")
    private EstadoServicioOrden estadoServicioOrden;

    @ManyToOne
    @JoinColumn(name = "id_orden_servicio")
    private OrdenServicio ordenServicio;
}
