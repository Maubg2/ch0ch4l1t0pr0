package com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.services;

import java.util.List;
import java.util.Optional;

import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.entities.Sede;

public interface SedeService {

    public List<Sede> listarSedes();

    public Optional<Sede> findById(Long id);

    public Sede guardar(Sede sede);

    public Optional<Sede> modificarSede(Long id, Sede sede);

    public Optional<Sede> eliminarSede(Long id);

}
