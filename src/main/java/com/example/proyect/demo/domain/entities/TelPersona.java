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

@Entity
@Table (name = "tel_persona")

public class TelPersona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "numero")
    @NotNull
    private int numero;

    @ManyToOne
    @JoinColumn(name = "num_doc")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "tipo_tel")
    private TipoTelefono tipoTelefonos;
}
