package com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.services;

import java.util.List;
import java.util.Optional;

import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.entities.Mesa;

public interface MesaService {

    public List<Mesa> listarMesas();

    public Optional<Mesa> findById(Long id);

    public Mesa guardar(Mesa mesa);

    public Optional<Mesa> modificarMesa(Long id, Mesa mesa);

    public Optional<Mesa> eliminarMesa(Long id);

    public List<Mesa> mesasPorSedeId(Long sedeId);

}
