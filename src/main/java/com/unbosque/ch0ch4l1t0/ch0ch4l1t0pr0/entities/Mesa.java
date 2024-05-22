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
@Table(name = "mesa")
public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "es_libre")
    private boolean esLibre;

    @Column(name = "cantidad_personas")
    private int cantidadPersonas;

    @Column(name = "fk_sede")
    private Long fkSede;

}
