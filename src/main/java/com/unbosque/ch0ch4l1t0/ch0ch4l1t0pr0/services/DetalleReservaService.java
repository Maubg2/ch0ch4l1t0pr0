package com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.services;

import java.util.List;

import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.entities.DetalleReserva;

public interface DetalleReservaService {

    public List<DetalleReserva> obtenerDetallesPorReserva(Long reservaId);

    public void cambiarEstado(Long detalleReservaId);

}
