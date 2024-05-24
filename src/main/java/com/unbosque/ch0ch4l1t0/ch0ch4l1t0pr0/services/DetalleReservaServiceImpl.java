package com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.entities.DetalleReserva;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.repositories.DetalleReservaRepository;

@Service
public class DetalleReservaServiceImpl implements DetalleReservaService{

    @Autowired
    private DetalleReservaRepository detalleReservaRepository;

    @Override
    public List<DetalleReserva> obtenerDetallesPorReserva(Long reservaId) {
        return detalleReservaRepository.findByReservaId(reservaId);
    }

    @Override
    public void cambiarEstado(Long detalleReservaId) {
        Optional<DetalleReserva> detalleReservaOpt = detalleReservaRepository.findById(detalleReservaId);
        if (detalleReservaOpt.isPresent()) {
            DetalleReserva detalleReserva = detalleReservaOpt.get();
            detalleReserva.setEstado(detalleReserva.getEstado().equals("1") ? "0" : "1");
            detalleReservaRepository.save(detalleReserva);
        }
    }

}
