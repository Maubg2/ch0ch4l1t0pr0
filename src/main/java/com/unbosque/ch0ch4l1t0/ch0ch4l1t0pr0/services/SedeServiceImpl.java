package com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.entities.Sede;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.repositories.SedeRepository;

import jakarta.transaction.Transactional;

@Service
public class SedeServiceImpl implements SedeService{

    @Autowired
    private SedeRepository repository;

    @Override
    public List<Sede> listarSedes() {
        return repository.findAll();
    }

    @Override
    public Optional<Sede> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Sede guardar(Sede sede) {
        return repository.save(sede);
    }

    @Override
    @Transactional
    public Optional<Sede> modificarReserva(Long id, Sede sede) {
        Optional<Sede> sedeBD = repository.findById(id);
        if(sedeBD.isPresent()){
            Sede sedeActualizada = new Sede();
            sedeActualizada.setCiudad(sede.getCiudad());
            sedeActualizada.setDireccion(sede.getDireccion());
            sedeActualizada.setNombre(sede.getNombre());
            sedeActualizada.setTelefono(sede.getTelefono());
            return Optional.of(repository.save(sedeActualizada));
        }
        return sedeBD;
    }

    @Override
    @Transactional
    public Optional<Sede> eliminarSede(Long id) {
        Optional<Sede> sedeOptional = repository.findById(id);
        sedeOptional.ifPresent(s -> {
            repository.delete(s);
        });
        return sedeOptional;
    }

}
