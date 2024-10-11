package com.example.proyect.demo.domain.entities;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table (name = "persona")

public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "numDocumento")
    @NotNull
    private int numDocumento;

    @Column(name = "nombre", length = 50)
    @NotNull
    private String nombre;

    @Column(name = "apellido", length = 50)
    private String apellido;

    @Column(name = "fechaRegistro")
    private Date fechaRegistro;

    @ManyToOne
    @JoinColumn(name = "idSucursal")
    private Sucursal sucursal;

    @ManyToOne
    @JoinColumn(name = "idDireccion")
    private Direccion direccion;

    @OneToMany(mappedBy = "persona")
    private List<TelPersona> telPersona;
}