package com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.entities.Sede;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.repositories.SedeRepository;

@Service
public class SedeServiceImpl implements SedeService{

    @Autowired
    private SedeRepository repository;

    @Override
    public List<Sede> listarSedes() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarSedes'");
    }

    @Override
    public Optional<Sede> findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Sede guardar(Sede sede) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'guardar'");
    }

    @Override
    public Optional<Sede> modificarReserva(Long id, Sede sede) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modificarReserva'");
    }

    @Override
    public Optional<Sede> eliminarSede(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarSede'");
    }

}
