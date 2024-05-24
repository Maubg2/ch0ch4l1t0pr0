package com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.entities.dto;

import java.util.Date;

public class AuditoriaDTO {

    private String descripcion;
    private Date fecha;
    private String tablaAfectada;
    private String nombreUsuario;

    
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getTablaAfectada() {
        return tablaAfectada;
    }
    public void setTablaAfectada(String tablaAfectada) {
        this.tablaAfectada = tablaAfectada;
    }
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }


    
}
