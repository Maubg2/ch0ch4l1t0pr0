package com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.services;

import java.util.List;
import java.util.Optional;

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


    @Override
    public Optional<TipoReserva> findById(Long id) {
        return tipoReservaRepository.findById(id);
    }


    @Override
    public void guardar(TipoReserva tipoReserva) {
        tipoReservaRepository.save(tipoReserva);
    }


    @Override
    public void modificarTipoReserva(Long id, TipoReserva tipoReservaModificada) {
        Optional<TipoReserva> tipoReservaOpt = tipoReservaRepository.findById(id);
        if (tipoReservaOpt.isPresent()) {
            TipoReserva tipoReserva = tipoReservaOpt.get();
            tipoReserva.setDescripcion(tipoReservaModificada.getDescripcion());
            tipoReserva.setPrecioTipoReserva(tipoReservaModificada.getPrecioTipoReserva());
            tipoReserva.setTipo(tipoReservaModificada.getTipo());
            tipoReservaRepository.save(tipoReserva);
        }
    }
    
}
