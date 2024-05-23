package com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.entities;

import java.util.Date;

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
@Table(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date fecha;

    @Column(name = "fk_tipo_reserva")
    private Long fkTipoReserva;

    @Column(name = "fk_sede")
    private Long fkSede;

    @Column(name = "fk_usuario")
    private Long fkUsuario;

    @Column(name = "fk_mesa")
    private Long fkMesa;

}
