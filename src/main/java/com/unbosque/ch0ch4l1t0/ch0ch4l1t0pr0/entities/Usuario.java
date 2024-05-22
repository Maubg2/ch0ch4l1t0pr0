package com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

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
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombres;
    private String apellidos;
    private String email;
    private String username;
    private String contrasena;
    private String telefono;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    @Column(name = "fk_rol")
    private Long fkRol;

    public Usuario(String nombres, String apellidos, String email, String username, String contrasena, String telefono,
            Date fechaNacimiento, Long fkRol) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.username = username;
        this.contrasena = contrasena;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.fkRol = fkRol;
    }

    public Usuario(){
        
    }

}
