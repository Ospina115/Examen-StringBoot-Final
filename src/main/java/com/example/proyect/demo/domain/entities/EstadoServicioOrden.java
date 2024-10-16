package com.example.proyect.demo.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "estado_servicio_orden")
public class EstadoServicioOrden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(length = 100, name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "estadoServicioOrden")
    @JsonIgnore
    private List<DetalleOrdenTrabajo> detalleOrdenTrabajos;
}
