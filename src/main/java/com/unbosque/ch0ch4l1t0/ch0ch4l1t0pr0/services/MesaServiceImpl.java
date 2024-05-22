package com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.entities.Mesa;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.repositories.MesaRepository;

import jakarta.transaction.Transactional;

@Service
public class MesaServiceImpl implements MesaService{

    @Autowired
    private MesaRepository repository;

    @Override
    public List<Mesa> listarMesas() {
        return repository.findAll();
    }

    @Override
    public Optional<Mesa> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Mesa guardar(Mesa mesa) {
        return repository.save(mesa);
    }

    @Override
    @Transactional
    public Optional<Mesa> modificarMesa(Long id, Mesa mesa) {
        Optional<Mesa> mesaBD = repository.findById(id);
        if(mesaBD.isPresent()){
            Mesa mesaActualizada = new Mesa();
            mesaActualizada.setCantidadPersonas(mesa.getCantidadPersonas());
            mesaActualizada.setEsLibre(mesa.isEsLibre());
            mesaActualizada.setFkSede(mesa.getFkSede());
            return Optional.of(repository.save(mesaActualizada));
        }
        return mesaBD;
    }

    @Override
    @Transactional
    public Optional<Mesa> eliminarMesa(Long id) {
        Optional<Mesa> mesaOptional = repository.findById(id);
        mesaOptional.ifPresent(m -> {
            repository.delete(m);
        });
        return mesaOptional;
    }

}
