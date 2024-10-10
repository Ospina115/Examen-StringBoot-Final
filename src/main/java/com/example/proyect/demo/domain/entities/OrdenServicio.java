package com.example.proyect.demo.domain.entities;

import java.sql.Date;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "ordenservicio")

public class OrdenServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numOrden ")
    private Long id;

    @Column (name = "fechaOrden")
    private Date  fechaOrden;
}
