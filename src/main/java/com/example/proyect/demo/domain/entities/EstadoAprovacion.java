package com.example.proyect.demo.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "estado_aprobacion")
public class EstadoAprovacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(length = 50)
    private String nombre;

    @OneToMany(mappedBy = "estadoAprovacion")
    @JsonIgnore
    private List<AprovacionServicio> AprovacionServicios;
}
