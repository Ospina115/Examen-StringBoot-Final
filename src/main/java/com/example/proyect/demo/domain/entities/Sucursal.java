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
import lombok.Data;

import java.sql.Date;

@Entity
@Table(name = "sucursal")
@Data
public class Sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSuc;

    @Column(name = "nombreSuc", length = 50)
    private String nombreSuc;

    @Column(name = "nit", length = 50)
    private String nit;

    @Column(name = "fecha_creacion")
    private Date fechaCreacion; 

    @ManyToOne
    @JoinColumn(name = "id_ciudad")
    private Ciudad ciudad;

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    @OneToMany(mappedBy = "sucursal")
    @JsonIgnore
    private List<Persona> personas; 

    @OneToMany(mappedBy = "sucursal")
    @JsonIgnore
    private List<EmpresaServicio> empresaServicios;
}