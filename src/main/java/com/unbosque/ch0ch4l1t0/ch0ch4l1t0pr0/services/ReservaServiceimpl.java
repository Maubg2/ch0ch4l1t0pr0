package com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.entities.Reserva;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.repositories.ReservaRepository;

import jakarta.transaction.Transactional;

@Service
public class ReservaServiceimpl implements ReservaService {

    @Autowired
    private ReservaRepository repository;

    @Override
    public List<Reserva> listarReservas() {
        return repository.findAll();
    }

    @Override
    public Optional<Reserva> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Reserva guardar(Reserva reserva) {
        return repository.save(reserva);
    }

    @Override
    @Transactional
    public Optional<Reserva> modificarReserva(Long id, Reserva reserva) {
        Optional<Reserva> reservaBD = repository.findById(id);
        if(reservaBD.isPresent()){
            Reserva reservaActualizada = new Reserva();
            reservaActualizada.setFecha(reserva.getFecha());
            reservaActualizada.setFkSede(reserva.getFkSede());
            reservaActualizada.setFkTipoReserva(reserva.getFkTipoReserva());
            reservaActualizada.setFkUsuario(reserva.getFkUsuario());
            return Optional.of(repository.save(reservaActualizada));
        }
        return reservaBD;
    }

    @Override
    @Transactional
    public Optional<Reserva> eliminarReserva(Long id) {
        Optional<Reserva> reservOptional = repository.findById(id);
        reservOptional.ifPresent(r -> {
            repository.delete(r);
        });
        return reservOptional;
    }

}
