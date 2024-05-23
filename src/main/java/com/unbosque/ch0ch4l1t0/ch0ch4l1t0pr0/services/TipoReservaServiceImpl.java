package com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.entities.TipoReserva;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.repositories.TipoReservaRepository;

@Service
public class TipoReservaServiceImpl implements TipoReservaService{

    @Autowired
    private TipoReservaRepository tipoReservaRepository;


    @Override
    public List<TipoReserva> listarTodos() {
       return tipoReservaRepository.findAll();
    }
    
}
