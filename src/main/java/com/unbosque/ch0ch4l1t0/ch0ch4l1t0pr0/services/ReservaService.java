package com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.services;

import java.util.List;
import java.util.Optional;

import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.entities.Mesa;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.entities.Reserva;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.entities.Sede;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.entities.TipoReserva;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.entities.Usuario;

public interface ReservaService {

    public List<Reserva> listarReservas();

    //Traer las reservas asociadas a un usuario
    public List<Reserva> listarReservasUsuario(Long userId);

    //Traer el tipo de reserva asociado a una reserva
    public TipoReserva listarTipoReservaReserva(Long reservaId);

    //Traer la sede asociada a la reserva
    public Sede listarSedeReserva(Long reservaId);

    //Traer la mesa asociada a la reserva
    public Mesa listarMesaReserva(Long reservaId);

    //Trae el usuario asociado a la reserva
    public Usuario listarUsuarioReserva(Long reservaId);

    public Optional<Reserva> findById(Long id);

    public Reserva guardar(Reserva reserva);

    public Optional<Reserva> modificarReserva(Long id, Reserva reserva);

    public Optional<Reserva> eliminarReserva(Long id);

    public List<Reserva> obtenerReservasPorUsuarioId(Long idUsuario);

}
