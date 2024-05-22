package com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "detalle_reserva")
public class DetalleReserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String estado;

    private String moneda;

    @Column(name = "precio_total")
    private int precioTotal;

    @Column(name = "fk_reserva")
    private Long fkReserva;

}
