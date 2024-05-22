package com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.entities.Auditoria;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.repositories.AuditoriaRepository;

import jakarta.transaction.Transactional;

@Service
public class AuditoriaServiceImpl implements AuditoriaService{

    @Autowired
    private AuditoriaRepository repository;

    @Override
    @Transactional
    public void crearAuditoria(Auditoria auditoria) {
        repository.save(auditoria);
    }

    @Override
    public List<Auditoria> listarAuditorias() {
        return repository.findAll();
    }

}
