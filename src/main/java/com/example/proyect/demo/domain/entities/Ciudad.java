package com.example.proyect.demo.domain.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "ciudad")
@Data
public class Ciudad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_region")
    @NotNull
    private Region region;

    @OneToMany(mappedBy = "ciudad")
    @JsonIgnore
    private List<Direccion> direccion;

    @OneToMany(mappedBy = "ciudad")
    @JsonIgnore
    private List<Sucursal> sucursales;
}