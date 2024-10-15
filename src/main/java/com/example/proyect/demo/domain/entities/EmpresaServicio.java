package com.example.proyect.demo.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import java.math.BigDecimal;

@Entity
@Table(name = "empresa_servicio")
public class EmpresaServicio {

    @Id
    @Column(name = "idSucursal")
    private int idSucursal;

    @Id
    @Column(name = "idServicio")
    private int idServicio;

    @Column(name = "valorServicio", precision = 10, scale = 2)
    private BigDecimal valorServicio; 

    @ManyToOne
    @JoinColumn(name = "idSucursal", referencedColumnName = "idSuc", insertable = false, updatable = false)
    private Sucursal sucursal;

    @ManyToOne
    @JoinColumn(name = "idServicio", referencedColumnName = "id", insertable = false, updatable = false)
    private Servicio servicio;

    
}
