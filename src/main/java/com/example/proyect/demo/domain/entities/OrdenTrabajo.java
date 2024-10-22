package com.example.proyect.demo.domain.entities;

import java.sql.Date;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "orden_trabajo")
@Data
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

    @ManyToOne
    @JoinColumn(name = "idEmpleado")
    private Persona persona;

    @Column(name = "numOrden")
    private Long numOrden;
    
    @ManyToOne
    @JoinColumn(name = "nro_orden")
    private OrdenServicio ordenServicio;

    @OneToMany(mappedBy = "ordenTrabajo")
    @JsonIgnore
    private List<AprovacionServicio> aprovacionServicios;

    @OneToMany(mappedBy = "ordenTrabajo")
    @JsonIgnore
    private List<DetalleOrdenTrabajo> detalleOrdenTrabajos;
}
