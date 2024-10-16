package com.example.proyect.demo.domain.entities;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @ManyToOne
    @JoinColumn(name = "numOrden")
    private OrdenTrabajo ordenTrabajo;

    @Column(name = "id_cliente")
    private Long idCliente;

    @ManyToOne
    @JoinColumn(name = "id_servicio")
    private Servicio servicio;

    @Column(length = 100, name = "hallazgo")
    private String hallazgo;

    @Column(length = 100, name = "solucion")
    private String solucion;

    @ManyToOne
    @JoinColumn(name = "id_estado_aprob")
    private EstadoAprovacion estadoAprovacion;
}
