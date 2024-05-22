package com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.entities.Auditoria;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.repositories.AuditoriaRepository;

@Service
public class AuditoriaServiceImpl implements AuditoriaService{

    @Autowired
    private AuditoriaRepository repository;

    @Override
    public void crearAuditoria(Auditoria auditoria) {
        repository.save(auditoria);
    }

}
