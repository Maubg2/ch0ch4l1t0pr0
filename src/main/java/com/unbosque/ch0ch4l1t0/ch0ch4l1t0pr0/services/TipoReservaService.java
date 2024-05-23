package com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.services;

import java.util.List;
import java.util.Optional;

import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.entities.TipoReserva;

public interface TipoReservaService{

    public List<TipoReserva> listarTodos();

    public Optional<TipoReserva> findById(Long id);

    public void guardar(TipoReserva tipoReserva);

    public void modificarTipoReserva(Long id, TipoReserva tipoReserva);

}
