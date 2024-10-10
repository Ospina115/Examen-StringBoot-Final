package com.example.proyect.demo.domain.entities;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "aprovacion_servicio")
@Data
public class AprovacionServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "numOrden")
    private int numOrden;

    @Column(name = "idCliente")
    private Long idCliente;

    @Column(name = "idServicio")
    private Long idServicio;

    @Column(length = 100, name = "hallazgo")
    private String hallazgo;

    @Column(length = 100, name = "solucion")
    private String solucion;

    @Column(name = "idEstadoAprobacion")
    private int idEstadoAprobacion;
}
