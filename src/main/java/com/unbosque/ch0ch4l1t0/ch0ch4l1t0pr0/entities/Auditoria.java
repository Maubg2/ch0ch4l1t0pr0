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
@Table(name = "auditoria")
public class Auditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;
    private Date fecha;

    @Column(name = "tabla_afectada")
    private String tablaAfectada;

    @Column(name = "fk_usuario")
    private Long fkUsuario;

    public Auditoria(String descripcion, Date fecha, String tablaAfectada, Long fkUsuario) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.tablaAfectada = tablaAfectada;
        this.fkUsuario = fkUsuario;
    }

    

}
