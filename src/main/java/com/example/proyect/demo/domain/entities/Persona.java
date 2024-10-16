package com.example.proyect.demo.domain.entities;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table (name = "persona")
@Data
public class Persona {

    @Id
    @Column(name = "num_Doc")
    private int numDoc;

    @Column(name = "nombre", length = 50)
    @NotNull
    private String nombre;

    @Column(name = "apellido", length = 50)
    private String apellido;

    @Column(name = "fecha_registro")
    private Date fechaRegistro;

    @ManyToOne
    @JoinColumn(name = "id_sucursal")
    private Sucursal sucursal;

    @ManyToOne
    @JoinColumn(name = "id_direccion")
    private Direccion direccion;

    @OneToMany(mappedBy = "persona")
    @JsonIgnore
    private List<TelPersona> telPersona;

    @OneToMany(mappedBy = "persona")
    @JsonIgnore
    private List<EmailPersona> emailPersonas;

    @ManyToOne
    @JoinColumn(name = "id_tipo_persona")
    private TipoPersona tipoPersonas;

    @OneToMany(mappedBy = "persona")
    @JsonIgnore
    private List<PersonaInsumo> PersonaInsumos;

    @OneToMany(mappedBy = "personas")
    @JsonIgnore
    private List<OrdenServicio> ordenServicios;

    @OneToMany(mappedBy = "persona")
    @JsonIgnore
    private List<OrdenServicio> ordenServicio;
}