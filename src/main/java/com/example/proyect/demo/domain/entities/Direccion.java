package com.example.proyect.demo.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "direccion")
@Data
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100)
    @NotNull
    private String calle;

    @Column(length = 100)
    @NotNull
    private String carrera;

    @Column(length = 200)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_ciudad")
    private Ciudad ciudad;
}
