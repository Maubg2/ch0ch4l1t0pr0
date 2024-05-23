package com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.services;

import java.util.List;
import java.util.Optional;

import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.entities.Reserva;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.entities.TipoReserva;

public interface ReservaService {

    public List<Reserva> listarReservas();

    public List<Reserva> listarReservasUsuario(Long userId);

    public TipoReserva listarTipoReservaReserva(Long reservaId);

    public Optional<Reserva> findById(Long id);

    public Reserva guardar(Reserva reserva);

    public Optional<Reserva> modificarReserva(Long id, Reserva reserva);

    public Optional<Reserva> eliminarReserva(Long id);

}
