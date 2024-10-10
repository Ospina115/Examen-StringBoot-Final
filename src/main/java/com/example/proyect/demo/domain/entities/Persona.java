package com.example.proyect.demo.domain.entities;

import java.sql.Date;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "persona")

public class Persona {

    @Id
    @Column(name = "numDocumento")
    private int numDocumento;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "fechaRegistro")
    private Date fechaRegistro;
}
