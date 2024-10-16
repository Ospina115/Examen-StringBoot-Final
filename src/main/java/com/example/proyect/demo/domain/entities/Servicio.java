package com.example.proyect.demo.domain.entities;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "servicio")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id; 

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "requiereInsumo")
    private boolean requiereInsumo;

    @OneToMany(mappedBy = "servicio")
    @JsonIgnore
    private List<PersonaInsumo> personaInsumos;

    @OneToMany(mappedBy = "servicio")
    @JsonIgnore
    private List<ServicioInsumo> servicioInsumos;

    @OneToMany(mappedBy = "servicio")
    @JsonIgnore
    private List<DetalleOrden> detalleOrdens;

    @OneToMany(mappedBy = "servicio")
    @JsonIgnore
    private List<DetalleOrdenTrabajo> detalleOrdenTrabajos;

    @OneToMany(mappedBy = "servicio")
    @JsonIgnore
    private List<AprovacionServicio> aprovacionServicios;
}
